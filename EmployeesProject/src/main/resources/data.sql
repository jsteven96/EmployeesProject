INSERT INTO Candidate (name, last_name, address, cellphone, city_name)
VALUES ('Javier Steven', 'Pérez Fernández', 'Calle 18 No. 6B - 64', '3132525462', 'Funza'),
('David Julian', 'Pérez Fernández', 'Calle A No. 1 23', '3218223838', 'Funza'),
('Miguel Ángel', 'Gutierrez Ibague', 'Carrera 13 26 C 4', '3204220106', 'Bogotá'),
('Camila Andrea', 'Aguirre Vargas', 'Carrera 1 1A - 56', '3560650302', 'Bogotá'),
('Patricia Ángela', 'Castillo Saco', 'Transversal 8 45 - C Sur', '23429923', 'Cali');

INSERT INTO Position (name)
VALUES ('Developer'),
('Project manager'),
('DB Administrator'),
('Designer'),
('Architect');

INSERT INTO Employee (person, position, salary)
VALUES (1, 1, 3000000),
(2, 3, 2500000),
(3, 4, 1800000),
(4, 5, 1000000),
(5, 2, 1500000);
