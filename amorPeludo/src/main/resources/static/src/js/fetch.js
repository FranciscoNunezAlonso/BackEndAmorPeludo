const itemsContainer = document.getElementById("list-items"); // Asegúrate de tener un elemento con el ID "list-items" en tu HTML

// Función para obtener y mostrar los productos
function getProducts() {
    fetch("https://amorpeludo.onrender.com/api/productos/")
        .then(response => {
            if (!response.ok) {
                throw new Error(`Network response was not ok: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            displayProducts(data);
        })
        .catch(error => {
            console.error("Error fetching products:", error);
        });
}

// Función para mostrar los productos en tarjetas
function displayProducts(products) {
    products.forEach(product => {
        const productCard = document.createElement("div");
        productCard.className = "col-12 col-md-6 col-lg-4 mb-3";
        productCard.innerHTML = `
        <div class="col cardProdsFlex">
        <div class="card cardProds h-80 w-100">
          <img src="${product.img1}" class="card-img-top imgCard" alt="image" onmouseover="changeImage(this, '${item.imgOnMouseover}')" onmouseout="resetImage(this)" ontouchstart="changeImage(this, '${item.imgontouchstart}')" ontouchend="resetImage(this)" >
        <div class="card-body cardProdsContent">
          <h6 class="card-title">${product.tittle}</h6>
            <h5 class="card-title">$${product.price}</h5>
              <p class="cardTextProds">${product.description}</p>
        </div>
        <div class="card-footer mt-4 mb-4 border-0 cardFooterBg">
        <a href="#" class="btn btn-primary btnProds">Comprar</a>
        <a href="#" class="btn btn-primary btnProds1">Agregar al carrito</a>
      </div>
        </div>
      </div>
        `;
        itemsContainer.appendChild(productCard);
    });
}

// Llamar a la función para obtener y mostrar los productos
getProducts();
