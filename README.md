# Loja Online de Jogos

Para o desenvolvimento da loja de jogos, foram escolhidas as seguintes estruturas:

+ Árvore binária de busca, para o armazenamento dos clientes;
+ Lista de compras, para o armazenamento das compras realizadas por cada cliente. Assim, cada cliente possui sua própria lista de compras;
+ Tabela Hash de jogos, para facilitar a busca por jogos, utilizando o idJogo como chave;
+ Outra Tabela Hash de jogos, utilizada para agrupar os jogos por data de lançamento, facilitando a busca dos jogos por essa informação;
+ Tabela Hash de compras, para que fosse possível realizar o calculo dos jogos com maior média de avaliação;

As estruturas utilizadas foram baseadas nas estruturas vistas em sala de aula.

## Estruturação

O projeto possui as pastas "Entidades" onde se encontram as classes que reprentam os registros dos 3 arquivos e "Estruturas" onde ficam as classes das estruturas mencionadas.

## Fluxo

Na parte principal da aplicação, são carregadas as estruturas de dados. Para cada estrutura, é realizada a leitura do arquivo e a inserção do registro na respectiva estrutura. Somente a inserção das compras que ficou condicionada à busca prévia por um cliente, na árvore de clientes, para posterior inclusão na lista de compras.

É mostrado um menu para a escolha das opções, conforme as etapas descritas no trabalho.
