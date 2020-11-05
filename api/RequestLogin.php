<?php
// Se connecter à la base de données
require_once "conf.php";

$request_method = $_SERVER["REQUEST_METHOD"];

$login = filter_input(INPUT_GET, 'login');
$mdp = filter_input(INPUT_GET, 'mdp');


switch($request_method) {
    case 'GET':
        if (isset($login) && isset($mdp)) {
            $user= getPseudo($login);


            if ($user != 'false') {

                $data = json_decode($user);
                $mdpBDD = $data->mdp;

                if (password_verify($mdp, $mdpBDD)) {
                    echo $user;
                } else {
                    echo "wrong_pw";
                }

            } else {
                echo "wrong_user";
            }
        } else {
            echo "no_param";
        }
        break;

    case 'POST':
        // Ajouter un produit
        break;

    default:
        // Requête invalide
        header("HTTP/1.0 405 Method Not Allowed");
        break;
}

function getPseudo($pseudo)
{
    $pdo=new PDO('mysql:host=localhost;dbname=alclicker','admin','php');
    $req='SELECT * FROM user WHERE pseudo = ?';
    $prep=$pdo->prepare($req);
    $prep->bindParam(1, $pseudo, PDO::PARAM_STR);
    $prep->execute();
    $response=$prep->fetch(PDO::FETCH_ASSOC);

    return json_encode($response, JSON_PRETTY_PRINT);
}