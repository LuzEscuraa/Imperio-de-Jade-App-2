# Imperio-de-Jade-App-2

Versão refeita do **Imperio-de-Jade-App**, seguindo arquitetura **CRUD** e uso de **API RESTful**.

Aplicação back-end criada para facilitar a vida do mestre de RPG do sistema **Tormenta: O Império de Jade**.

---

## 🚀 Funcionalidades

O projeto inclui três funcionalidades principais:

1. **Dicionário de termos/nomes**  
   - Guia para nomes escritos em "tamuriano" com explicações breves.  
   - Facilita a vida do mestre durante a campanha.

2. **Gerador de encontros aleatórios**  
   - Calcula encontros entre jogadores e monstros de forma automática.  

3. **Calculadora de XP pós-encontro**  
   - Mostra quanto de XP cada participante recebe.  
   - Calcula quanto falta para avançar de nível.

---

## ⚙ Tecnologias Utilizadas

- **Java 17**  
- **Spring Boot**  
- **Jakarta Validation**  
- **Spring Data JPA**  
- **H2 Database** (ou outro banco de sua escolha)

---

## 📦 Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/Imperio-de-Jade-App-2.git
2. Entre na Pasta do Projeto
   ```bash
   cd Imperio-de-Jade-App-2
3. Rode a Aplicação
   ```bash
   ./mvnw spring-boot:run
4. Acesse a API via Postman ou seu cliente HTTP favorito!


## 📌 Observações
- O POST exige que todos os campos sejam preenchidos.
- O PUT permite atualizar campos individualmente, podendo deixar alguns em branco.
- O projeto é ideal para mestres de RPG que desejam automatizar cálculos e referências rápidas.
