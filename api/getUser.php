<?php
  // Se connecter à la base de données
  require_once "conf.php";
  include "fonctions.php";

  $request_method = $_SERVER["REQUEST_METHOD"];

  $IdUser = filter_input(INPUT_GET, 'id_user');
  

  switch($request_method) {
      case 'GET':
          if (!empty($IdUser)) {
              // Récupérer l'user
              $id = intval($IdUser);
              getUser($id);
          } else {
              // Récupérer tous les users
              getAllUser();
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