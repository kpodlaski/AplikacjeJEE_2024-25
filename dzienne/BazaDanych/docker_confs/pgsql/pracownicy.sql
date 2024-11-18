
BEGIN TRANSACTION;

CREATE SEQUENCE seq_id_stanowisko INCREMENT 1 START 1;
CREATE SEQUENCE seq_id_pracownik INCREMENT 1 START 1;
CREATE SEQUENCE seq_id_jednostka INCREMENT 1 START 1;

CREATE TABLE IF NOT EXISTS Stanowisko (
                                          "id"	INTEGER NOT NULL DEFAULT nextval('seq_id_stanowisko'),
                                          "nazwa"	TEXT,
                                          PRIMARY KEY("id")
);
ALTER SEQUENCE seq_id_stanowisko OWNED BY Stanowisko.id;

CREATE TABLE IF NOT EXISTS Pracownik (
                                         "id"	INTEGER NOT NULL DEFAULT nextval('seq_id_pracownik'),
                                         "imie"	TEXT,
                                         "nazwisko"	TEXT,
                                         "stanowisko"	INTEGER,
                                         PRIMARY KEY("id"),
                                         FOREIGN KEY("stanowisko") REFERENCES Stanowisko("id")
);

ALTER SEQUENCE seq_id_pracownik OWNED BY Pracownik.id;

CREATE TABLE IF NOT EXISTS Jednostka (
                                         "id"	INTEGER NOT NULL DEFAULT nextval('seq_id_jednostka'),
                                         "nazwa"	TEXT,
                                         PRIMARY KEY("id")
);

ALTER SEQUENCE seq_id_jednostka OWNED BY Jednostka.id;

CREATE TABLE IF NOT EXISTS PracJednLnk (
                                           "id_prac"	INTEGER,
                                           "id_jedn"	INTEGER,
                                           FOREIGN KEY("id_prac") REFERENCES Pracownik("id"),
                                           FOREIGN KEY("id_jedn") REFERENCES Jednostka("id")
);



INSERT INTO Stanowisko (nazwa) VALUES ('kierownik');
INSERT INTO Stanowisko (nazwa)  VALUES ('sekretarz');
INSERT INTO Stanowisko (nazwa)  VALUES ('dyrektor');
INSERT INTO Pracownik (imie, nazwisko, stanowisko) VALUES ('Tomasz','Tomaszewski',3);
INSERT INTO Pracownik (imie, nazwisko, stanowisko) VALUES ('Agata','Agatkowska',1);
INSERT INTO Pracownik (imie, nazwisko, stanowisko) VALUES ('Juliusz','Juliański',2);
INSERT INTO Pracownik (imie, nazwisko, stanowisko) VALUES ('Alicja','Alicewska',2);
INSERT INTO Pracownik (imie, nazwisko, stanowisko) VALUES ('Stefan','Stefanowski',1);
INSERT INTO Jednostka (nazwa) VALUES ('Produkcja');
INSERT INTO Jednostka (nazwa) VALUES ('Księgowość');


INSERT INTO PracJednLnk VALUES (1,2);
INSERT INTO PracJednLnk VALUES (2,1);
INSERT INTO PracJednLnk VALUES (3,1);
INSERT INTO PracJednLnk VALUES (3,2);
INSERT INTO PracJednLnk VALUES (4,1);
INSERT INTO PracJednLnk VALUES (5,2);

COMMIT;
