# Application Flow

### User Sign up
1. User signs up from the welcome page (Seperate button for sign up and login)
2. User fills out the sign up form and submits
3. Request goes to sign up servlet
4. Servlet creates a user object and then creates user in the database
5. Response to user confirming addition(show a message in the jsp)
6. 
### User Sign in
1. User signs in from the welcome page
2. User enters username and password on form and submits
3. If user is authenticated, the server will handle loading users saved recipes and grocery lists. JDBCRealm used for authentication
   (users, users_roles, and roles table)
4. If authentication fails, show error message/page

### View Recipes
1. Option only available to logged in users with proper role
1. Page sends a request to view recipes servlet along with criteria(recipe name if searching for a specific recipe)
2. Servlet uses recipe dao to select recipes based on criteria
3. Dao performs select and creates recipe objects from results
4. Dao returns list of recipes matching criteria to servlet
5. Servlet sends list back to recipes jsp
6. Recipe jsp displays recipes
7. Consider paging results so page doesn't get too long and too much data is sent

### View Grocery List
1. Option only available to logged in users with proper role
1. Page sends a request to view grocery list
2. Servlet uses grocery list dao to select grocery list
3. Dao performs select and creates report object from results
4. Dao returns list of report to servlet
5. Servlet sends list back to grocery list jsp
6. Grocery list jsp displays grocery list

### Add Recipe
1. Option only available to logged in users with proper role
2. User selects add recipe (available on all pages if user is logged in)
3. User enters recipe details in add recipe jsp(through link or manual)
4. Details are sent to Add Recipe servlet
5. Servlet creates recipe object
6. Servlet sends object to dao
7. Dao adds recipe to the database
8. Servlet sends confirmation to recipe page that recipe has been added

### Add Grocery List
1. Option only available to logged in users with proper role
2. User selects create grocery list (available on all pages if user is logged in)
3. Request is sent to Recipe dao to get all recipes
4. Dao performs select and creates a list of recipes.
5. Dao returns list to grocery list jsp
6. Grocery list jsp displays recipes with button to add to shopping list
7. Button sends recipe to grocery list servlet
8. Grocery list servlet sends all items in recipe to grocery list dao
9. Grocery list dao creates grocery list object
10. Dao adds grocery list to the database (amounts for items with the same name will be additive)
11. Servlet sends confirmation to grocery list page that recipe has been added to shopping list.
12. Grocery list is updated to show items added


