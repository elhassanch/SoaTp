package sud.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import sud.domain.Product;
import sud.webservices.ProductsManager;

public class WSConsumer {
    public static void main(String[] args) throws  Exception{
        URL wsdlUrl = new URL("http://localhost:2020/webservices/ProductsManager");
        QName serviceName = new QName("http://webservices.sud/","ProductsManagerImplService");
        Service serviceClient = Service.create(wsdlUrl,serviceName);
        ProductsManager  portProxy = serviceClient.getPort(ProductsManager.class);
        Product product1 = new Product(1l,"p1",111d);
        Product product2 = new Product(2l,"p2",120d);
        Product product3 = new Product(3l,"p3",50d);

        /* Ajout des produits */
        portProxy.addProduct(product1);
        portProxy.addProduct(product2);
        portProxy.addProduct(product3);

        /* Visualisation des prix */
        System.out.println("Prix du Produit 1 : "+portProxy.getProductPrice(1l));
        System.out.println("Prix du Produit 2 : "+portProxy.getProductPrice(2l));
        System.out.println("Prix du Produit 3 : "+portProxy.getProductPrice(3l));

        /* Visualisation du produit 2 */
        System.out.println(portProxy.getProduct(2l));

        /* Visualisation des produits */
        System.out.println(portProxy.getProducts());

        /* suppression du produit 3 */
        System.out.println(portProxy.deleteProduct(3l));

        /* Suppression des produits */
        System.out.println(portProxy.deleteAllProducts());

    }
}
