<?php

require_once "conf.php";

  $request_method = $_SERVER["REQUEST_METHOD"];

  $IdUser = filter_input(INPUT_GET, 'id_user');
  
  $IdObjet = filter_input(INPUT_GET, 'id_objet');


  
  switch($request_method) {
      case 'GET':
          if (!empty($IdUser)) {
              // Récupérer l'user
              $id = intval($IdUser);
              $idObjet = intval($IdObjet);
              AchatObjet($id, $idObjet);
          }
          break;

      case 'POST':
          // Ajouter un produit
          AddProduct();
          break;

      default:
          // Requête invalide
          header("HTTP/1.0 405 Method Not Allowed");
          break;
  }

  
  //retourne toutes les infos de tout les utilisateurs
function AchatObjet($IdUser, $IdObjet)
{
    $pdo=new PDO('mysql:host=localhost;dbname=alclicker','root','');


    $reqMonnaieUser='SELECT monnaie FROM user WHERE id_user = ?';
    $prep=$pdo->prepare($reqMonnaieUser);
    $prep->bindParam(1, $IdUser, PDO::PARAM_STR);
    $prep->execute();
    $UserMonnaie=$prep->fetch(PDO::FETCH_BOTH);
    
    $reqPrixObjetr='SELECT prix FROM skinitem WHERE id_skin = ?';
    $prep=$pdo->prepare($reqPrixObjetr);
    $prep->bindParam(1, $IdObjet, PDO::PARAM_STR);
    $prep->execute();
    $PrixObjet=$prep->fetch(PDO::FETCH_BOTH);
    
    $reqVerifPoss='SELECT * FROM skinposs WHERE id_skin = ? AND id_user';
    $prep=$pdo->prepare($reqVerifPoss);
    $prep->bindParam(1, $IdObjet, PDO::PARAM_STR);
    $prep->execute();
    $VerifPoss=$prep->fetch(PDO::FETCH_BOTH);
    
    

    if($UserMonnaie['monnaie'] > $PrixObjet['prix']){
        if(!isset($VerifPoss)){
            $reqDialogue='INSERT INTO skinposs(id_user, id_skin) VALUES (?, ?);';
            $prep=$pdo->prepare($reqDialogue);

            $prep->bindParam(1, $idUser, PDO::PARAM_INT);
            $prep->bindParam(2, $idObjet, PDO::PARAM_INT);

            $prep->execute();

            //opp bien passé
            echo 1;
        }else{
            
            //si il le possede deja
            echo 2;
        }
        
    }else{
        //si il n'a pas assez d'argent
        echo 3;
    }
}

