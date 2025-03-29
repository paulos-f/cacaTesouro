# Caça ao Tesouro

## Introdução
"Caça ao Tesouro" é um aplicativo interativo desenvolvido para Android utilizando Jetpack Compose e Navigation. O objetivo do jogo é responder corretamente a uma série de perguntas para encontrar o tesouro escondido.

## Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **Framework UI:** Jetpack Compose
- **Gerenciamento de Navegação:** Navigation Compose
- **Arquitetura:** ComponentActivity, Composable Functions

## Fluxograma do Aplicativo
```plaintext
[Início]
    |
    v
[Tela Inicial]
    |
    v
[Iniciar Jogo] --> [Pergunta 1]
    |
    |--> [Resposta Correta] --> [Pergunta 2]
    |       |
    |       |--> [Resposta Correta] --> [Pergunta 3]
    |       |       |
    |       |       |--> [Resposta Correta] --> [Tela do Tesouro]
    |       |
    |       |--> [Resposta Errada] --> [Tente Novamente]
    |
    |--> [Resposta Errada] --> [Tente Novamente]
    |
    v
[Tela do Tesouro] --> [Voltar para Home]
```

## Como Jogar
1. **Abrir o aplicativo** e acessar a tela inicial.
2. **Clicar em "Iniciar"** para começar o jogo.
3. **Responder corretamente** às perguntas para avançar.
4. **Se errar**, tente novamente até acertar.
5. **Ao responder todas as perguntas corretamente**, o usuário encontra o tesouro!
6. **Na tela do tesouro**, é possível reiniciar o jogo e voltar para a tela inicial.

## Funcionalidades Principais
✅ Sistema de perguntas e respostas.  
✅ Feedback imediato sobre as respostas.  
✅ Navegação entre telas via Jetpack Compose.  
✅ Opção de reiniciar o jogo ao encontrar o tesouro.  

## Melhorias Futuras
- Adicionar mais perguntas dinâmicas.
- Implementar um temporizador para responder as perguntas.
- Criar um sistema de pontuação.
- Melhorar a interface com animações e efeitos visuais.

## Contribuição
Sinta-se à vontade para sugerir melhorias ou contribuir com o projeto. Qualquer sugestão pode ser enviada via Pull Request ou Issue.

## Licença
Este projeto é de código aberto e pode ser utilizado livremente para fins educacionais e pessoais.

---
![image](https://github.com/user-attachments/assets/f4f51760-85a6-4662-935a-4db8328f80c2)

![image](https://github.com/user-attachments/assets/0f7da830-69ea-472e-a5a3-932c371a7ada)

![image](https://github.com/user-attachments/assets/ba4de932-268b-4d3d-ab2d-e08eea1b3f31)


