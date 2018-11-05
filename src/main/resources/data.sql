INSERT INTO
    restaurant(id, `name`, address)
VALUES
    (1, 'Mami etterme', 'Budapest');

INSERT INTO
    recipe(id, `name`)
VALUES
    (1, 'Lasange');

INSERT INTO
    ingredient(id, `name`)
VALUES
    (1, 'sajt');

INSERT INTO
    ingredient_recipes(ingredients_id, recipes_id)
VALUES
    (1, 1);

INSERT INTO
   recipe_restaurants(recipes_id, restaurants_id)
VALUES
    (1, 1);
