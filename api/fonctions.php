<?php

//retourne toutes les infos de tout les utilisateurs
function getAllUser()
  {
      $pdo=new PDO('mysql:host=localhost;dbname=alclicker','admin','php');
      $req='SELECT * FROM user';
      $prep=$pdo->prepare($req);
      $prep->execute();
      $response=$prep->fetchAll(PDO::FETCH_ASSOC);
    
    echo json_encode($response, JSON_PRETTY_PRINT);
  }

function getUser($id)
  {
      $pdo=new PDO('mysql:host=localhost;dbname=alclicker','admin','php');
      $req='SELECT * FROM user WHERE id_user = ?';
      $prep=$pdo->prepare($req);
      $prep->bindParam(1, $id, PDO::PARAM_INT);
      $prep->execute();
      $response=$prep->fetch(PDO::FETCH_ASSOC);

    echo json_encode($response, JSON_PRETTY_PRINT);
  }