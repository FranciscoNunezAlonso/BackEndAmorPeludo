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
            <div class="card-box card h-100">
                <img src="${product.img1}" class="card-img-top" alt="Foto del producto">
                <div class="card-body">
                    <h5 class="card-title">${product.title}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="text-center"><strong>$${product.price}</strong></p>
                    <div class="row">
                        <div class="col">
                            <div style="text-align: center">
                                <button class="btn btn-lg btn-block" type="submit"><strong>Agregar</strong></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `;
        itemsContainer.appendChild(productCard);
    });
}

// Llamar a la función para obtener y mostrar los productos
getProducts();
