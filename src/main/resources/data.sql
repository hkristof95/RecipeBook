INSERT INTO
    `user`(id, address, email, `name`, password, phone_number, role)
VALUES
    (1,'admin street','admin@admin.com','admin','$2a$10$ewD/7ir3zbZPMw6ZjOKleu7dwzkV0eBhzOs.ZdFPXYFcO8u2hDIg.','1234',1);

INSERT INTO
    `user`(id, address, email, `name`, password, phone_number, role)
VALUES
    (2,'user street','user@user.com','user','$2a$10$LqeK7TcK/ENnVCAbQ5pmi.DT.3ugXw5MBiR9JjJ5/UWw15.RcDpY.','1234',0);

INSERT INTO
    restaurant(id, `name`, address, user_id, description, phone_number)
VALUES
    (1, 'Mami etterme', 'Budapest', 1, 'Olcso es finom', '063012345678');

INSERT INTO
    restaurant(id, `name`, address, user_id,description, phone_number)
VALUES
    (2, 'Pizza Taco', 'Budapest', 1,'Jo a pizza', '063012345678');

INSERT INTO
    restaurant(id, `name`, address, user_id, description, phone_number)
VALUES
    (3, 'BOR sok BOR', 'Budapest', 1, 'Draga de jo', '063012345678');

INSERT INTO
    recipe(id, `name`, description)
VALUES
    (1, 'Lasange', 'Mindig jo valasztas');

INSERT INTO
    recipe(id, `name`, description)
VALUES
    (2, '4 sajtos pizza', 'Nagyon jo a tesztaja');

INSERT INTO
    recipe(id, `name`, description)
VALUES
    (3, 'Vörös boros marha', 'Eleg eros');

INSERT INTO
    recipe(id, `name`, description)
VALUES
    (4, 'Kaposztas teszta', 'Sok cukorral az igazi');

INSERT INTO
    ingredient(id, `name`)
VALUES
    (1, 'sajt');
INSERT INTO
    ingredient(id, `name`)
VALUES
    (2, 'vörösbor');
INSERT INTO
    ingredient(id, `name`)
VALUES
    (3, 'kaposzta');
INSERT INTO
    ingredient(id, `name`)
VALUES
    (4, 'teszta');

INSERT INTO
    ingredient_recipes(ingredients_id, recipes_id)
VALUES
    (1, 1);
INSERT INTO
    ingredient_recipes(ingredients_id, recipes_id)
VALUES
    (1, 4);
INSERT INTO
    ingredient_recipes(ingredients_id, recipes_id)
VALUES
    (2, 1);
INSERT INTO
    ingredient_recipes(ingredients_id, recipes_id)
VALUES
    (2, 2);
INSERT INTO
    ingredient_recipes(ingredients_id, recipes_id)
VALUES
    (3, 3);

INSERT INTO
   recipe_restaurants(recipes_id, restaurants_id)
VALUES
    (1, 1);
INSERT INTO
   recipe_restaurants(recipes_id, restaurants_id)
VALUES
    (4, 1);
INSERT INTO
   recipe_restaurants(recipes_id, restaurants_id)
VALUES
    (2, 1);
INSERT INTO
   recipe_restaurants(recipes_id, restaurants_id)
VALUES
    (2, 2);
INSERT INTO
   recipe_restaurants(recipes_id, restaurants_id)
VALUES
    (3, 3);

