<?php
//tester la base de donnée

  require_once "conf.php";

  $request_method = $_SERVER["REQUEST_METHOD"];

  $IdUser = filter_input(INPUT_GET, 'id_user');
  
  $Score = filter_input(INPUT_GET, 'score');
  
  switch($request_method) {
      case 'GET':
          if (!empty($IdUser)) {
              // Récupérer l'user
              $id = intval($IdUser);
              $score = intval($Score);
              changeScore($id, $score);
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

function changeScore($IdUser, $Score)
{

  $pdo=new PDO('mysql:host=localhost;dbname=alclicker','root','');
    $reqBestScore='SELECT best_score FROM user WHERE id_user = ?';
    $prep=$pdo->prepare($reqBestScore);
    $prep->bindParam(1, $IdUser, PDO::PARAM_STR);
    $prep->execute();
    $scoreUser=$prep->fetch(PDO::FETCH_BOTH);
    
    if($scoreUser['best_score'] < $Score){
        $reqNewScore='UPDATE user SET best_score = ? WHERE id_user= ?;';
        $prep=$pdo->prepare($reqNewScore);
        $prep->bindParam(1, $Score, PDO::PARAM_INT);
        $prep->bindParam(2, $IdUser, PDO::PARAM_INT);
        $prep->execute();
        echo "changed";
    } else {
        echo "unchanged";
    }
}
