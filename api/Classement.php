<?php

  $pdo=new PDO('mysql:host=localhost;dbname=alclicker','root','');


$scoreUser = "";

$reqBestScore='SELECT * FROM classement ORDER BY score';
$prep=$pdo->prepare($reqBestScore);
$prep->execute();
$scoreUser=$prep->fetchAll(PDO::FETCH_ASSOC);

echo json_encode($scoreUser, JSON_PRETTY_PRINT);