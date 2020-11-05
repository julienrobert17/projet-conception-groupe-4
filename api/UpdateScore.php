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
        
        CompareClassement($IdUser, $Score);
        echo "best_changed";
    } else {
        echo "best_unchanged";
    }
}


function CompareClassement($IdUser, $ScoreUser){
    $pdo=new PDO('mysql:host=localhost;dbname=alclicker','root','');
    
    echo 1;
    
    $reqBestScore='SELECT score, id_user FROM classement ORDER BY score';
    $prep=$pdo->prepare($reqBestScore);
    $prep->execute();
    $TabscoreUser=$prep->fetchAll(PDO::FETCH_ASSOC);
    
    var_dump($TabscoreUser);
    
    foreach($TabscoreUser  as $key => $Score){
        if($Score['score'] < $ScoreUser){
            $reqBestScore='DELETE FROM classement WHERE id_user = ?';
            $prep=$pdo->prepare($reqBestScore);
            $prep->bindParam(1, $Score['id_user'], PDO::PARAM_INT);
            $prep->execute();
            
            $reqPseudoUser='SELECT pseudo FROM user WHERE id_user = ?';
            $prep2=$pdo->prepare($reqPseudoUser);
            $prep2->bindParam(1, $IdUser, PDO::PARAM_INT);
            $prep2->execute();
            $PseudoUser=$prep2->fetch(PDO::FETCH_ASSOC);
            
            $reqInsertClass='INSERT INTO classement(pseudo, score, id_user) VALUES (?, ?, ?);';
            $prep3=$pdo->prepare($reqInsertClass);
            $prep3->bindParam(1, $PseudoUser['pseudo'], PDO::PARAM_STR);
            $prep3->bindParam(2, $ScoreUser, PDO::PARAM_INT);
            $prep3->bindParam(3, $IdUser, PDO::PARAM_INT);
            $prep3->execute();

            break;
        }

        
    }
    
    
    
    
}