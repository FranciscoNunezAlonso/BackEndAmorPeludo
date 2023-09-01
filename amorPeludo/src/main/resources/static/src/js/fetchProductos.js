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
        productCard.className = "col cardProdsFlex";
        productCard.innerHTML = `
            <div class="card cardProds h-80 w-100">
                <div class="nosotrosCard">
                <img src="${product.img1}" class=" top" alt="image">
                <img src="${product.img2}" class=" bottom" alt="image2">
                </div>
                <div class="card-body">
                    <h5 class="card-title">${product.tittle}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="text-center"><strong>$${product.price}</strong></p>
                </div>
                <div class="card-footer mt-4 mb-4 border-0 cardFooterBg">
                <a href="#" class="btn btn-primary btnProds">Comprar</a>
                <a href="#" class="btn btn-primary btnProds1">Agregar al carrito</a>
              </div>
            </div>
        `;
        itemsContainer.appendChild(productCard);
    });
}

// Llamar a la función para obtener y mostrar los productos
getProducts();

window.addEventListener("load", function (event) {
    event.preventDefault();
  
    fetch('https://amorpeludo.onrender.com/api/productos/')
      .then(response => response.json())
      .then(data => {
        data.forEach(p => {
          addItem({
            "tittle": p.title,
            "price": p.price,
            "description": p.description,
            "img": p.img,
            "imgOnMouseover": p.imgOnMouseover,
            "imgontouchstart": p.ontouchstart
          });
        });
      })
      .catch(error => {
        console.error('Error al obtener datos de la API:', error);
      });
  });
  window.addEventListener("load", function (event) {
    event.preventDefault();
    if (localStorage.getItem("elemento") != null) {
      JSON.parse(localStorage.getItem("elemento")).forEach((p) => {
        addItem({
          "title": p.title,
          "price": p.price,
          "description": p.description,
          "img": p.img2,
          "imgOnMouseover": p.imgOnMouseover, // Agregar esta línea para el atributo imgOnMouseover
          "imgontouchstart": p.ontouchstart // Agregar esta línea para el atributo imgontouchstart
  
        });
      });
  
    }
  });