# Processo seletivo Bridge 2020.2

## Descrição

Esse projeto foi feito como parte da segunda etapa do processo seletivo para bolsista de Dev. Full Stack do Laboratório Bridge. Um site simples que no frontend calcula o fatorial do número inserido e mantém um registro dos 10 últimos cálculos, enquanto o backend realiza os cálculos e mantém registro de suas atividades no terminal.
  
## Tecnologias e bibliotecas utilizadas

A versão de Java 14 OpenJDK foi utilizada para o backend. Nele, algumas bibliotecas básicas foram usadas para obter acesso ao horário local, formatação de horário e I/O de dados. A biblioteca math foi utilizar apenas para evitar os problemas (mais comuns) de overflow que inteiros possuem.

Algumas bibliotecas de httpserver foram utilizadas para criar o servidor e tratar as requisições do frontend. Além da página de para acesso, foi disponibilizado uma API que retorna o fatorial do argumento (/fatorial/{arg}), que a própria página utiliza. Um handler foi criado para tratar a API e outro para resolver todas as requisições que a página principal faz, incluindo o HTML e todos os recursos utilizados.

Tratando do HTML e CSS, o design foi (obviamente) inspirado na identidade visual da Bridge e foi utilizado o framework Materialize para estilizar alguns elementos da página, apesar da maior parte utilizar apenas CSS básico.

O frontend utilizou também de JavaScript básico, onde possue algumas funções que atualizam os elementos da página pelo uso dos botões e uma função exclusiva para evitar que o usuário entre com dados indesejados para cálculo, desde números não-naturais até letras e símbolos.
  
## Como executar o projeto localmente

Após baixar o reposítório, voce só precisa executar o Backend pelo Java, ou se preferir pode recompilar o arquivo fatorial.java, e acessar o endereço http://localhost:8001/ no seu navegador (Quase todos os navegadores devem funcionar, com excessão talvez do IE). Com o servidor aberto, você pode também acessar o endereço http://localhost:8001/fatorial/{arg} com um número inteiro de argumento e deve receber como retorno o fatorial dele.
