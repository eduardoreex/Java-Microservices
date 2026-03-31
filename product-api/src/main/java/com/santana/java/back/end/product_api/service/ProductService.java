// O endereço da nossa classe na pasta service
package com.santana.java.back.end.product_api.service;

// Importando as ferramentas do Java (Listas) e do Spring
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Importando as nossas próprias classes (As caixas, as entidades e o estoquista)
import com.santana.java.back.end.product_api.dto.ProductDTO;
import com.santana.java.back.end.product_api.model.Product;
import com.santana.java.back.end.product_api.repository.ProductRepository;

// @Service: É o crachá do Chef de Cozinha! Avisa o Spring que esta classe contém as regras de negócio.
@Service
public class ProductService {
    // @Autowired: Lembra da "Injeção de Dependência"?
    // Em vez de você digitar "ProductRepository rep = new ProductRepository()", o Spring liga (conecta) o Service ao Repository automaticamente por este "cabo".
    @Autowired
    private ProductRepository productRepository;
    // --- 1. METODO: LISTAR TODOS ---
    public List<ProductDTO> getAll() {
        // O estoquista vai no banco e traz uma lista de PRODUTOS (Entidades).
        List<Product> products = productRepository.findAll();
        // 🚨 A MÁGICA DA ESTEIRA (STREAM) 🚨
        // O banco devolve 'Product', mas a internet só aceita 'ProductDTO'. Precisamos converter a lista toda!
        return products
                .stream() // Coloca os produtos numa "esteira rolante" de fábrica.
                .map(ProductDTO::convert) // A máquina que passa em cada produto e transforma em DTO.
                .collect(Collectors.toList()); // Recolhe todos os DTOs no final da esteira e coloca numa nova Lista.
    }
    // --- 2. METODO: BUSCAR PRODUTOS POR UMA CATEGORIA ESPECÍFICA ---
    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        // Lembra daquela Query customizada gigante que você fez no Repository? Nós chamamos ela aqui!
        List<Product> products = productRepository.getProductByCategory(categoryId);

        // Novamente, passa na esteira para converter para DTO.
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }
    // --- 3. METODO: BUSCAR POR CÓDIGO (SKU) ---
    public ProductDTO findByProductIdentifier(String productIdentifier) {
        // O estoquista busca um único produto pelo código de barras dele.
        Product product = productRepository.findByProductIdentifier(productIdentifier);

        // Se o produto existir (não for nulo), ele converte para DTO e devolve. Se não existir, devolve nulo (por enquanto).
        if (product != null) {
            return ProductDTO.convert(product);
        }
        return null;
    }
    // --- 4. METODO: SALVAR UM NOVO PRODUTO ---
    public ProductDTO save(ProductDTO productDTO) {
        // Recebe a "Caixa" da internet (DTO). Traduz para a linguagem do banco (Entity).
        Product product = Product.convert(productDTO);

        // Manda o estoquista salvar no banco. O banco gera o ID e devolve o produto salvo.
        product = productRepository.save(product);

        // Converte o produto salvo de volta para "Caixa" (DTO) e devolve para a tela do usuário com o ID preenchido!
        return ProductDTO.convert(product);
    }

    // --- 5. METODO: DELETAR ---
    public void delete(long productId) {
        // Primeiro, o estoquista procura a gaveta (findById).
        Optional<Product> product = productRepository.findById(productId);

        // Se a gaveta tiver um produto dentro (isPresent), ele manda o estoquista deletar.
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
    }
}