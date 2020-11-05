<?php

// Se connecter à la base de données
require_once "conf.php";

$request_method = $_SERVER["REQUEST_METHOD"];

$login = filter_input(INPUT_GET, 'login', FILTER_SANITIZE_STRING);
$mdp = filter_input(INPUT_GET, 'mdp');
$email = filter_input(INPUT_GET, 'email', FILTER_SANITIZE_EMAIL);

switch($request_method) {
    case 'GET':
        if (isset($login) && isset($mdp) && $email) {
            if (getEmail($email) == 'false' && getPseudo($login) == 'false') {
                createUser($login,$mdp,$email);
            } else {
                echo "already_exist";
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

function getEmail($email)
{
    $pdo=new PDO('mysql:host=localhost;dbname=alclicker','admin','php');
    $req='SELECT * FROM user WHERE email = ?';
    $prep=$pdo->prepare($req);
    $prep->bindParam(1, $email, PDO::PARAM_STR);
    $prep->execute();
    $response=$prep->fetch(PDO::FETCH_ASSOC);

    return json_encode($response, JSON_PRETTY_PRINT);
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

function createUser($login, $mdp, $email)
{
    $mdpcrypte = password_hash($mdp, PASSWORD_BCRYPT);

    $pdo=new PDO('mysql:host=localhost;dbname=alclicker','admin','php');
    $req='INSERT INTO user (pseudo, email, mdp, monnaie, best_score) VALUES (:pseudo, :email, :mdp, 0, 0)';
    $prep=$pdo->prepare($req);
    $prep->bindParam(':pseudo', $login, PDO::PARAM_STR);
    $prep->bindParam(':email', $email, PDO::PARAM_STR);
    $prep->bindParam(':mdp', $mdpcrypte, PDO::PARAM_STR);
    $prep->execute();

    echo "user_created";
}