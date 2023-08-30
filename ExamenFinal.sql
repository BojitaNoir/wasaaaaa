create database isai;
use isai;

-- Tabla de roles
CREATE TABLE roles (
    role_id INT PRIMARY KEY auto_increment,
    role_name VARCHAR(50) NOT NULL
);

-- Insertar roles iniciales
INSERT INTO roles (role_id, role_name) VALUES
    (1, 'ADMIN_ROLE'),
    (2, 'INSTRUCTOR_ROLE'),
    (3, 'USER_ROLE');

-- Tabla de personas
CREATE TABLE persons (
    person_id INT PRIMARY KEY auto_increment,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    birthdate DATE NOT NULL
);

-- Tabla de usuarios
CREATE TABLE users (
    user_id INT PRIMARY KEY auto_increment,
    person_id INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES persons(person_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

-- Tabla de clases
CREATE TABLE classes (
    class_id INT PRIMARY KEY auto_increment,
    class_name VARCHAR(100) NOT NULL,
    description TEXT,
    instructor_id INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES persons(person_id)
);

-- Tabla de temario
CREATE TABLE curriculum (
    curriculum_id INT PRIMARY KEY auto_increment,
    class_id INT NOT NULL,
    content TEXT NOT NULL,
    FOREIGN KEY (class_id) REFERENCES classes(class_id)
);

-- Tabla de inscripciones
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY auto_increment,
    user_id INT NOT NULL,
    class_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (class_id) REFERENCES classes(class_id)
);


INSERT INTO persons (person_id, first_name, last_name, curp, birthdate) VALUES
    (1, 'Isai', 'Acosta', 'CURP1', '1990-01-01'),
    (2, 'Ivan', 'Gutierrez', 'CURP2', '1985-05-15'),
    (3, 'Pablo', 'Josue', 'CURP3', '1995-09-30');

-- Insertar registros en users
INSERT INTO users (user_id, person_id, email, password, status, role_id) VALUES
    (1, 1, 'admin@gmail.com', 'admin', 'active', 1),
    (2, 2, 'instructor@gmail.com', 'instructor', 'active', 2),
    (3, 3, 'user@gmail.com', 'user', 'active', 3);
