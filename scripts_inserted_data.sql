-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema AlephArt
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AlephArt
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AlephArt` ;
USE `AlephArt` ;

-- -----------------------------------------------------
-- Table `AlephArt`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`book` (
  `id_book` INT NOT NULL AUTO_INCREMENT,
  `book_photo` LONGBLOB NULL,
  `book_name` VARCHAR(100) NULL,
  `book_description` VARCHAR(1200) NULL,
  PRIMARY KEY (`id_book`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`userprofile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`userprofile` (
  `id_user_profile` INT NOT NULL AUTO_INCREMENT,
  `profile_photo` LONGBLOB NULL,
  `banner` LONGBLOB NULL,
  `about_me` VARCHAR(1200) NULL,
  `profession` VARCHAR(200) NULL,
  `book_id_book` INT NOT NULL,
  PRIMARY KEY (`id_user_profile`),
  INDEX `fk_userProfile_book1_idx` (`book_id_book` ASC) VISIBLE,
  CONSTRAINT `fk_userProfile_book1`
    FOREIGN KEY (`book_id_book`)
    REFERENCES `AlephArt`.`book` (`id_book`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(70) NULL,
  `last_name` VARCHAR(70) NULL,
  `phone_number` BIGINT(13) NULL,
  `password` VARCHAR(30) NULL,
  `email` VARCHAR(70) NULL,
  `userprofile_id_user_profile` INT NOT NULL,
  PRIMARY KEY (`id_user`, `userprofile_id_user_profile`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_user_userProfile_idx` (`userprofile_id_user_profile` ASC) VISIBLE,
  CONSTRAINT `fk_user_userProfile`
    FOREIGN KEY (`userprofile_id_user_profile`)
    REFERENCES `AlephArt`.`userprofile` (`id_user_profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`posts` (
  `id_posts` INT NOT NULL AUTO_INCREMENT,
  `posts_date` DATE NULL,
  `posts_description` VARCHAR(1200) NULL,
  `post_file` LONGBLOB NULL,
  `user_id_user` INT NOT NULL,
  `user_userprofile_id_user_profile` INT NOT NULL,
  PRIMARY KEY (`id_posts`),
  INDEX `fk_posts_user1_idx` (`user_id_user` ASC, `user_userprofile_id_user_profile` ASC) VISIBLE,
  CONSTRAINT `fk_posts_user1`
    FOREIGN KEY (`user_id_user` , `user_userprofile_id_user_profile`)
    REFERENCES `AlephArt`.`user` (`id_user` , `userprofile_id_user_profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`comments` (
  `id_comment` INT NOT NULL AUTO_INCREMENT,
  `comment_date` DATE NULL,
  `comment_description` VARCHAR(1200) NULL,
  `posts_id_posts` INT NOT NULL,
  PRIMARY KEY (`id_comment`),
  INDEX `fk_comments_posts1_idx` (`posts_id_posts` ASC) VISIBLE,
  CONSTRAINT `fk_comments_posts1`
    FOREIGN KEY (`posts_id_posts`)
    REFERENCES `AlephArt`.`posts` (`id_posts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`eventmode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`eventmode` (
  `id_event_mode` INT NOT NULL AUTO_INCREMENT,
  `mode_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_event_mode`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`eventcategory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`eventcategory` (
  `id_event_category` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(15) NULL,
  PRIMARY KEY (`id_event_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`locationcity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`locationcity` (
  `id_location_city` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(50) NULL,
  PRIMARY KEY (`id_location_city`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`locationstate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`locationstate` (
  `id_location_state` INT NOT NULL AUTO_INCREMENT,
  `state_name` VARCHAR(50) NULL,
  PRIMARY KEY (`id_location_state`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlephArt`.`events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AlephArt`.`events` (
  `id_events` INT NOT NULL AUTO_INCREMENT,
  `event_name` VARCHAR(100) NULL,
  `event_description` VARCHAR(1500) NULL,
  `event_photo` LONGBLOB NULL,
  `event_date` DATE NULL,
  `event_time` TIME NULL,
  `user_id_user` INT NOT NULL,
  `user_userprofile_id_user_profile` INT NOT NULL,
  `eventmode_id_event_mode` INT NOT NULL,
  `eventcategory_id_event_category` INT NOT NULL,
  `locationcity_id_location_city` INT NOT NULL,
  `locationstate_id_location_state` INT NOT NULL,
  PRIMARY KEY (`id_events`, `eventmode_id_event_mode`, `eventcategory_id_event_category`, `locationcity_id_location_city`, `locationstate_id_location_state`),
  INDEX `fk_events_user1_idx` (`user_id_user` ASC, `user_userprofile_id_user_profile` ASC) VISIBLE,
  INDEX `fk_events_eventmode1_idx` (`eventmode_id_event_mode` ASC) VISIBLE,
  INDEX `fk_events_eventCategory1_idx` (`eventcategory_id_event_category` ASC) VISIBLE,
  INDEX `fk_events_locationCity1_idx` (`locationcity_id_location_city` ASC) VISIBLE,
  INDEX `fk_events_locationState1_idx` (`locationstate_id_location_state` ASC) VISIBLE,
  CONSTRAINT `fk_events_user1`
    FOREIGN KEY (`user_id_user` , `user_userprofile_id_user_profile`)
    REFERENCES `AlephArt`.`user` (`id_user` , `userprofile_id_user_profile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_eventmode1`
    FOREIGN KEY (`eventmode_id_event_mode`)
    REFERENCES `AlephArt`.`eventmode` (`id_event_mode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_eventCategory1`
    FOREIGN KEY (`eventcategory_id_event_category`)
    REFERENCES `AlephArt`.`eventcategory` (`id_event_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_locationCity1`
    FOREIGN KEY (`locationcity_id_location_city`)
    REFERENCES `AlephArt`.`locationcity` (`id_location_city`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_locationState1`
    FOREIGN KEY (`locationstate_id_location_state`)
    REFERENCES `AlephArt`.`locationstate` (`id_location_state`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- ------------------------------------------------------ --
-- ---------------- INSERCIÓN  DE  DATOS ---------------- --
-- ------------------------------------------------------ --

SELECT * FROM book;
SELECT * FROM userprofile;
SELECT * FROM user;
SELECT * FROM posts;
SELECT * FROM comments;
SELECT * FROM eventmode;
SELECT * FROM eventcategory;
SELECT * FROM locationcity;
SELECT * FROM locationstate;
SELECT * FROM events;

-- Inserciones para la tabla book (portafolio)
INSERT INTO `AlephArt`.`book` (`book_photo`, `book_name`, `book_description`) VALUES 
(NULL, 'Sueños en Acuarela', 'Una colección de paisajes soñadores en acuarela'),
(NULL, 'Bocetos Urbanos', 'Bocetos rápidos capturando la vida en la ciudad'),
(NULL, 'Ilustraciones Digitales', 'Arte digital moderno con un toque único'),
(NULL, 'Expresiones Abstractas', 'Pinturas abstractas audaces y coloridas'),
(NULL, 'Portafolio Fotográfico', 'Capturando momentos en el tiempo a través del lente');

-- Inserciones para la tabla userprofile
INSERT INTO `AlephArt`.`userprofile` (`profile_photo`, `banner`, `about_me`, `profession`, `book_id_book`) VALUES 
(NULL, NULL, 'Apasionada artista de acuarela', 'Artista de Acuarela', 1),
(NULL, NULL, 'Dibujante urbano recorriendo las calles de CDMX', 'Artista de Bocetos', 2),
(NULL, NULL, 'Ilustradora digital con amor por los temas fantásticos', 'Artista Digital', 3),
(NULL, NULL, 'Pintor abstracto explorando emociones a través del color', 'Artista Abstracto', 4),
(NULL, NULL, 'Fotógrafa freelance capturando los hermosos momentos de la vida', 'Fotógrafa', 5);

-- Inserciones para la tabla user
INSERT INTO `AlephArt`.`user` (`first_name`, `last_name`, `phone_number`, `password`, `email`, `userprofile_id_user_profile`) VALUES 
('Elena', 'Martínez', '5626283720', 'contr@Seña1', 'elena.martinez@email.com', 1),
('Miguel', 'García', '4611223344', 'bocet0#202', 'miguel.garcia@email.com', 2),
('Sofía', 'López', '5563344556', 'arted#igit24al', 'sofia.lopez@email.com', 3),
('Lucas', 'Fernández', '5544556677', 'abstracto#99', 'lucas.fernandez@email.com', 4),
('Olivia', 'Rodríguez', '5634655667', 'oLIv@023', 'olivia.rodriguez@email.com', 5);

-- Inserciones para la tabla posts
INSERT INTO `AlephArt`.`posts` (`posts_date`, `posts_description`, `post_file`, `user_id_user`, `user_userprofile_id_user_profile`) VALUES 
('2024-09-15', 'Nueva obra en acuarela: Atardecer sobre el Manzanares', NULL, 1, 1),
('2024-09-16', 'Boceto rápido de la Sagrada Familia', NULL, 2, 2),
('2024-09-17', 'Última ilustración digital: Espíritu del bosque', NULL, 3, 3),
('2024-09-18', 'Explorando emociones a través de formas abstractas', NULL, 4, 4),
('2024-09-19', 'Fotografía callejera: Callejones ocultos de Madrid', NULL, 5, 5);

-- Inserciones para la tabla comments
INSERT INTO `AlephArt`.`comments` (`comment_date`, `comment_description`, `posts_id_posts`, `user_id_user`, `user_userprofile_id_user_profile`) VALUES 
('2024-09-15', '¡Obra absolutamente impresionante!', 1, 2, 2),
('2024-09-16', '¡Me encanta la energía en este boceto!', 2, 3, 3),
('2024-09-17', 'Los detalles son increíbles', 3, 4, 4),
('2024-09-18', 'Esta pieza me habla', 4, 5, 5),
('2024-09-19', '¡Gran composición!', 5, 1, 1);

INSERT INTO `AlephArt`.`eventmode` 
(`mode_name`) 
VALUES
('Presencial'),
('Virtual');
select * from eventmode;


INSERT INTO `AlephArt`.`eventcategory` 
(`category_name`) 
VALUES
('Arte Urbano'),
('Tecnologías'),
('Música'),
('Dibujo'),
('Talleres');
select * from eventcategory;

INSERT INTO `AlephArt`.`locationcity` 
(`city_name`) 
VALUES
('Acapulco de Juárez'),
('Aguascalientes'),
('Apatzingán de la Constitución'),
('Apodaca'),
('Buena Vista'),
('Cabo San Lucas'),
('Campeche'),
('Cancún'),
('Celaya'),
('Chalco de Díaz Covarrubias'),
('Chetumal'),
('Chicoloapan'),
('Chihuahua'),
('Chimalhuacán'),
('Chilpancingo de los Bravo'),
('Cholula de Rivadavia'),
('Ciudad Acuña'),
('Ciudad Cuauhtémoc'),
('CDMX'),
('Ciudad del Carmen'),
('Ciudad Guzmán'),
('Ciudad Juárez'),
('Ciudad López Mateos'),
('Ciudad Madero'),
('Ciudad Obregón'),
('Ciudad Valles'),
('Ciudad Victoria'),
('Coahuila'),
('San Luis Potosí'),
('Colima'),
('Comitán de Domínguez'),
('Córdoba'),
('Cuautitlán'),
('Cuautitlán Izcalli'),
('Cuautla'),
('Cuernavaca'),
('Culiacán Rosales'),
('Delicias'),
('Durango'),
('Ecatepec de Morelos'),
('Ensenada'),
('El Pueblito'),
('Fresnillo'),
('García'),
('General Escobedo'),
('Gómez Palacio'),
('Guadalajara'),
('Guadalupe'),
('Guanajuato'),
('Guaymas'),
('Hermosillo'),
('Hidalgo del Parral'),
('Iguala'),
('Irapuato'),
('Ixtapaluca'),
('Jiutepec'),
('Juárez'),
('Kanasín'),
('La Paz'),
('Lagos de Moreno'),
('León'),
('Los Mochis'),
('Manzanillo'),
('Matamoros'),
('Mazatlán'),
('Mérida'),
('Mexicali'),
('Minatitlán'),
('Miramar'),
('Monclova'),
('Monterrey'),
('Morelia'),
('Naucalpan de Juárez'),
('Navojoa'),
('Nezahualcóyotl'),
('Nogales'),
('Nuevo Laredo'),
('Oaxaca de Juárez'),
('Ojo de Agua'),
('Orizaba'),
('Pachuca de Soto'),
('Playa del Carmen'),
('Piedras Negras'),
('Poza Rica de Hidalgo'),
('Puebla de Zaragoza'),
('Puerto Vallarta'),
('Querétaro'),
('Ramos Arizpe'),
('Reynosa'),
('Rosarito'),
('Río Bravo'),
('Salamanca'),
('Saltillo'),
('San Cristóbal de las Casas'),
('San Francisco Coacalco'),
('San José del Cabo'),
('San Juan Bautista Tuxtepec'),
('San Juan del Río'),
('San Luis Potosí'),
('San Luis Río Colorado'),
('San Nicolás de los Garza'),
('San Miguel de Allende'),
('San Pablo de las Salinas'),
('San Pedro Garza García'),
('Santa Catarina'),
('Soledad de Graciano Sánchez'),
('Tampico'),
('Tapachula'),
('Tehuacán'),
('Temixco'),
('Tepexpan'),
('Tepic'),
('Tijuana'),
('Tlalnepantla de Baz'),
('Tlaquepaque'),
('Toluca de Lerdo'),
('Tonalá'),
('Torreón'),
('Tulancingo de Bravo'),
('Tulum'),
('Tuxtla Gutiérrez'),
('Uruapan del Progreso'),
('Veracruz'),
('Villa de Álvarez'),
('Villa Nicolás Romero'),
('Villahermosa'),
('Xalapa-Enríquez'),
('Xico'),
('Zacatecas'),
('Zamora de Hidalgo'),
('Zapopan');
SELECT * FROM locationcity;


INSERT INTO `AlephArt`.`locationstate` 
(`state_name`) 
VALUES
('Aguascalientes'),
('Baja California'),
('Baja California Sur'),
('Campeche'),
('Chiapas'),
('Chihuahua'),
('Coahuila'),
('Colima'),
('Durango'),
('Guanajuato'),
('Guerrero'),
('Hidalgo'),
('Jalisco'),
('Mexico'),
('Mexico City'),
('Michoacán'),
('Morelos'),
('Nayarit'),
('Nuevo León'),
('Oaxaca'),
('Puebla'),
('Querétaro'),
('Quintana Roo'),
('San Luis Potosí'),
('Sinaloa'),
('Sonora'),
('Tabasco'),
('Tamaulipas'),
('Tlaxcala'),
('Veracruz'),
('Yucatán'),
('Zacatecas');
SELECT * FROM locationstate;

-- Inserciones para la tabla events
INSERT INTO `AlephArt`.`events` (`event_name`, `event_description`, `event_photo`, `event_date`, `event_time`, `user_id_user`, `user_userprofile_id_user_profile`, `eventmode_id_event_mode`, `eventcategory_id_event_category`, `locationcity_id_location_city`, `locationstate_id_location_state`) VALUES 
('Taller de Acuarela', 'Aprende técnicas de acuarela con Elena Martínez', NULL, '2024-10-15', '14:00:00', 1, 1, 2, 1, 1, 1),
('Encuentro de Bocetos Urbanos', 'Únete a Miguel para un día de bocetos urbanos', NULL, '2024-10-20', '10:00:00', 2, 3, 1, 1, 2, 2),
('Muestra de Arte Digital', 'Exposición en línea de las últimas obras de Sofía', NULL, '2024-10-25', '19:00:00', 3, 3, 2, 4, 3, 3),
('Exposición de Arte Abstracto', 'Exposición individual de Lucas Fernández', NULL, '2024-11-01', '18:00:00', 4, 4, 2, 1, 1, 4),
('Paseo Fotográfico Urbano', 'Explora las joyas ocultas de México con Olivia', NULL, '2024-11-05', '11:00:00', 5, 5, 1, 2, 3, 5);