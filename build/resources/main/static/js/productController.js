const createHTMLList = (index, title, description, targetDate) =>
`
<tr>
  <td scope="row">${title}</td>
  <td>${description}</td>
  <td>${targetDate}</td>
</tr>
`;

//  <td><button type="button" class="btn btn-danger btn-sm">delete</button></td>

//<div class="col-lg-4">
//<div class="card" style="width: 18rem;">
//    <div class="card-body">
//    <img src=${imageURL} class="card-img-top" alt="image">
//        <h5 class="card-title">${title}</h5>
//        <p class="card-text">${description}</p>
//        <p class="card-text">${targetDate}</p>
//        <a id="${index}" href="#" class="btn btn-primary" data-toggle="modal" data-target="#productModal">More</a>
//    </div>
//</div>
//</div>


//function displayProductDetail(item) {
//    document.querySelector("#modalName").innerText = item.oName;
//    document.querySelector("#modalImg").src = item.oImageUrl;
//    document.querySelector("#modalStyle").innerText = item.oStyle;
//    document.querySelector("#modalPrice").innerText = item.oPrice;
//}


class ProductsController {
    constructor() {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the array
    addItem(title, description, targetDate) {
        var productController = this;

        const item = {
         title: title,
         description: description,
         targetDate: targetDate
        };

        // Push the item to the items property
        //productController._items.push(item);
         const formData = new FormData();
         formData.append("title", title);
         formData.append("description", description);
         formData.append("targetDate", targetDate);

         console.log(title);
         console.log(description);
         console.log(targetDate);
        for (var pair of formData.entries()) {
            console.log(pair[0]+ ', ' + pair[1]);}

         var object = {};
         formData.forEach(function(value, key){
             object[key] = value;
         });
//         var json = JSON.stringify(object);

         fetch('http://localhost:8080/item/add', {
             method: 'POST', // or 'PUT'
             headers: {
                 'Content-Type': 'application/json',
//                 'content-type': 'undefined',
//                 'mimeType': 'application/octet-stream'
             },
//             body: formData
               body: JSON.stringify(object)
             })
             .then(response => response.json())
             .then(data => {
                 console.log('Success:', data);
                 alert("Successfully added to TODO List")
                 //this.displayItem();         //To display in the table from ProductForm.html
             })
             .catch((error) => {
                 console.error('Error:', error);
                 alert("Error adding item to TODO List")
             });
    }

    displayItem() {
        //fetch data from database using the REST API endpoint from Spring Boot
         var productController = this;
         productController._items = [];

        fetch('http://127.0.0.1:8080/item/all')
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);

                data.forEach(function (item, index) {
                    const itemObj = {
                        oId: item.id,
                        oTitle: item.title,
                        oDescription: item.description,
                        oTargetDate: item.targetDate,
                   };

                productController._items.push(itemObj);
              });

              productController.render();

            })
            .catch(function(error) {
                console.log(error);
            });
        }

    render() {
        var productController = this;
        const productHTMLList = [];

         //Display products after getting from the database
         for (var i=0; i< productController._items.length; i++) {
             const item = productController._items[i];

             //var loc = window.location.href;
             //var full = item.oImageUrl.pathname;

             const productHTML = createHTMLList(i, item.oTitle, item.oDescription,  item.oTargetDate);
             productHTMLList.push(productHTML)
         }

         const pHtml = productHTMLList.join('\n');
         const itemsContainer = document.querySelector('#tbody');
         itemsContainer.innerHTML = pHtml;

         for (let i=0; i< productController._items.length; i++)
         {
             const item = productController._items[i];
             document.getElementById(i).addEventListener("click", function() { displayProductDetail(item);});
         }
    }
}   //End of ProductsController class
