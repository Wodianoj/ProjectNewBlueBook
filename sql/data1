INSERT INTO `mydb`.`interpretations`
(`INTERPRETATION_ID`,
`NAME`,
`AVAILABLE`)
VALUES
(1, "ufo", true),
(2, "samolot",true),
(3, "ptak", true),
(4, "pterodaktyl", false),
(5, "superman", false);
INSERT INTO `mydb`.`classifications`
(`CLASSIFICATION_ID`,
`NAME`,
`AVAILABLE`)
VALUES
(1, "Bliskie spotkanie", true ),
(2, "Ognista kula", true ),
(3, "Wizja", false),
(4, "Przekaz podprogowy", false);
INSERT INTO `mydb`.`roles`
(`ROLE_ID`,
`NAME`,
`DESCRIPTION`)
VALUES
(1, "Administrator systemu", "Zarządzanie użytkownikami"),
(2, "Administrator danych", "Zarządzanie danymi (obserwatorzy, klasyfikacje,
interpretacje"),
(3, "Analityk", "Tworzenie analiz"),
(4, "Czytelnik", "Przeglądanie danych");
INSERT INTO `mydb`.`functionalities`
(`FUNCTIONALITY_ID`,
`NAME`)
VALUES
(1, "LOGIN"),
(2, "LOGOUT"),
(3, "USER_MANAGEMENT"),
(4, "VIEW_USERS"),
(5, "EDIT_USER"),
(6, "ADD_USER"),
(7, "SEARCH_OBSERVATIONS");
INSERT INTO `mydb`.`access`
(`ACCESS_ID`,
`LEVEL`,
`DESCRIPTION`)
VALUES
(1, 0, "Dane jawne"),
(2, 1, "Dane poufne"),
(3, 2, "Dane tajne"),
(4, 3, "Dane ściśle tajne");