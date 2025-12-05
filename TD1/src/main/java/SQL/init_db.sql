1- Création database
 CREATE BATABASE product_management_db;

2- Création du nouvel utilisateur
CREATE USER product_manager_user WITH PASSWORD '123456';

3- Privilèges de l''user sur la base
GRANT CREATE ON SCHEMA public TO product_manager_user;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO product_manager_user;

GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO product_manager_user;