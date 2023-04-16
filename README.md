# microapp
## microapp-products

Docker image was built with spring profile "docker". When running the image provide DB_HOST parameter as it is provided in docker-compose file.

### Endpoints

GET /products - Get all products
POST /products - Create a product
PUT /products - Update product
GET /products/{id} - Get product by id
DELETE /products/{id} - Delete product by id
