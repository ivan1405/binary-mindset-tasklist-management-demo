DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;

-- projects
CREATE TABLE projects (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(40) NOT NULL,
    description VARCHAR(100) NOT NULL,
    created_on TIMESTAMP,
    last_modified TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO projects VALUES (1, 'shopping list', 'This is my shopping list', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');
INSERT INTO projects VALUES (2, 'work at home', 'List to save all the things to do at home', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');

--------------------------------------------------------

-- tasks
CREATE TABLE tasks (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    project_id INTEGER NOT NULL,
    title VARCHAR(40) NOT NULL,
    description VARCHAR(100) NOT NULL,
    created_on TIMESTAMP,
    last_modified TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT task_fk FOREIGN KEY (project_id) REFERENCES `projects` (id)
);

INSERT INTO tasks VALUES (1, 1, 'buy milk', 'the cheapest one!', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');
INSERT INTO tasks VALUES (2, 1, 'buy bread', 'check if there is with cereals, otherwise the normal one', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');
INSERT INTO tasks VALUES (3, 1, 'caffee', 'no caffee, no coding :)', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');
INSERT INTO tasks VALUES (4, 2, 'clean bathroom', '', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');
INSERT INTO tasks VALUES (5, 2, 'call my friend Pepe', 'facebook said that today is his birthday :P', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');
INSERT INTO tasks VALUES (6, 2, 'play videogames', 'what else?', '2016-11-16 06:43:19.77', '2016-11-16 06:43:19.77');