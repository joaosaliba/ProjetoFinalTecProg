# Sistema de Gerenciamento de Estoque

## Descrição:

Nossa empresa tem feito o controle de estoque de forma manual há bastante tempo, porém está na hora de uma modernização! As mercadorias em estoque estão todas em um arquivo do tipo CSV, onde as colunas são ID do produto, nome, quantidade, categoria e preço. Nossa aplicação deve ser capaz de ler este arquivo CSV e gravar estas informações em uma tabela de nossa base de dados. Após gravadas as informações, alguns relatórios serão necessários (utilize streams para gerá-los).

## Funcionalidades:

1. **Leitura de Arquivo CSV e Gravação em Banco de Dados**: A aplicação deve ser capaz de ler o arquivo CSV contendo as informações do estoque e gravá-las em uma tabela no banco de dados.

2. **Relatórios**: Implemente métodos que respondam às seguintes perguntas:

    - Quantas categorias de produtos temos.
    - Quantos produtos de cada categoria temos em estoque.
    - Valor médio dos produtos.
    - Listagem de produtos com menos de 3 unidades em estoque (estoque baixo).

## Utilização:

1. Clone este repositório para sua máquina local.
2. Instale as dependências do projeto.
3. Execute a aplicação.

## Requisitos do Sistema:

- Java 17 ou superior.
- Banco de dados compatível (PostgreSQL).
- Dependências do projeto (ver arquivo `pom.xml` para detalhes).

## Como Executar:

1. Compile e execute a aplicação.
2. Siga as instruções para importar o arquivo CSV e gravar as informações no banco de dados.
3. Utilize os métodos disponíveis para gerar os relatórios necessários.



## Contribuição:

Contribuições são bem-vindas! Fique à vontade para abrir uma *issue* ou enviar um *pull request* com melhorias, correções de bugs ou novas funcionalidades.

## Licença:

Este projeto está licenciado sob a [MIT License](LICENSE).

---

Este é um exemplo básico de como você pode organizar a documentação para o seu projeto de Gerenciamento de Estoque. Certifique-se de adaptá-lo às necessidades específicas do seu projeto.