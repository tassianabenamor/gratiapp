<p align="center">
<img width=200 src="https://user-images.githubusercontent.com/87051404/207923619-e3e40e7b-88ec-4053-bff4-67ca0464a97d.png" />
</p>

# :canoe: GratiApp - Gratidão Diária

O aplicativo de anotações ideal para quem quer registrar todos os dias as gratidões mais marcantes de sua vida

Motivo: Ser um espaço para autoescrita através do aplicativo GratiApp

### Requisitos

Utilização de smartphone com sistema operacional Android para executar o aplicativo 

Para baixar o aplicativo no seu dispositivo Android, acesse a [Play Store](https://play.google.com/store/apps/details?id=br.edu.infnet.gratiapp).

### Funcionalidades

Assista aqui o [vídeo](https://youtu.be/SUIHYixV5sQ) demonstrando as funcionalidades do aplicativo

- Cadastro e autenticação de usuário utilizando Firebase
- Consumo de API para consulta de endereço do usuário
- Uso do nome do usuário após autenticação
- Adicionar, visualizar e editar gratidões
- Gerenciamento de coleções

## ✔️ Técnicas, tecnologias e linguagens utilizadas

### As técnicas utilizadas para isso são

- `CardView`: container para apresentar cada produto na lista de gratidões
- `RecyclerView`: listagem das gratidões
- `ConstraintLayout` e `LinearLayout`: ViewGroup padrão para implementar todos os layouts
- `ImageView`: View para apresentar imagens no App
- `View Binding`: busca de views do layout de forma segura
- `Toast`: Exibição de mensagem comunicando o sucesso da ação tomada pelo usuário
- `Personalização de tema`: modificação de cores para o tema do App
- `AdMob`: monetização app para mobile
- `Retrofit`: consumo de API

### Tecnologias utilizadas

- `Android Studio`: IDE
- `Firebase Authentication`: autenticação de usuário
- `Firestore Database`: banco de dados remoto
- `Realtime Database`: sincronização de dados em tempo real
- `Storage`: armazenamento e vinculação de conteúdo gerado pelo usuário em nuvem

### Linguagens utilizadas

- `Kotlin`: Linguagem de programação
- `XML`: Linguagem de marcação

*Nenhum framework foi utilizado*

## :computer: Telas
<!--
Cores do app (HEX): 
#E1D6C7 | #C6B49B | #97500C | #6F3600 | #4C2500
#728DC5 | #334E98 | #172B75 | #0A185A | #040D46 -->

### Login e cadastro de usuário

![image](https://user-images.githubusercontent.com/87051404/208009068-a0793777-f71f-45b2-bcf3-2c2d2512a301.png)

### Lista e cadastro de novas gratidões

![image](https://user-images.githubusercontent.com/87051404/208009351-bc624f10-8939-4ffd-b827-acbfe9e63f25.png)

### Visualizar e editar gratidões

![image](https://user-images.githubusercontent.com/87051404/208009713-7d3784dc-a925-47e4-a423-0ba0c2ae6cfd.png)

## :robot: Abrir e rodar o projeto

Após baixar o projeto, você pode abri-lo utilizando o Android Studio. Para isso, na tela de launcher, clique em:
- Open an Existing Project
- Encontre o local em que o projeto está e o selecione. Se o projeto estiver no formato zip, será necessário extraí-lo antes de realizar a busca pelo arquivo
- Por último, clique em OK

### Observação

O Android Studio deve executar algumas tasks do Gradle para configuração do projeto

Após as tasks finalizarem, o app GratiApp pode ser executado

<hr>

*Trabalho feito para as disciplinas de "Desenvolvimento Android: Kotlin" e "Segurança, Monetização e Publicação de Aplicativos Android"*
