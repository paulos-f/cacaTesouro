package com.example.cacatesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureHuntApp()
        }
    }
}

@Composable
fun TreasureHuntApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("question/{attempt}") { backStackEntry ->
            val attempt = backStackEntry.arguments?.getString("attempt")?.toIntOrNull() ?: 1
            QuestionScreen(navController, attempt)
        }
        composable("treasure") {
            TreasureScreen(navController)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Caça ao Tesouro")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("question/1") }) {
            Text("Iniciar")
        }
    }
}

@Composable
fun QuestionScreen(navController: NavController, attempt: Int) {
    var answer by remember { mutableStateOf("") }
    var feedback by remember { mutableStateOf("") }
    val correctAnswer = "C" // Exemplo de resposta correta

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pergunta $attempt: Qual a próxima letra após 'B'?")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { answer = "A" }) {
            Text("A")
        }
        Button(onClick = { answer = "B" }) {
            Text("B")
        }
        Button(onClick = { answer = "C" }) {
            Text("C")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Sua resposta: $answer")
        Text(feedback)

        // Botão de Voltar para a pergunta anterior
        if (attempt > 1) {
            Button(onClick = { navController.popBackStack() }) {
                Text("Voltar")
            }
        }

        if (answer.isNotEmpty()) {
            if (answer == correctAnswer) {
                feedback = "Você acertou!"
                if (attempt < 3) {
                    Button(onClick = { navController.navigate("question/${attempt + 1}") }) {
                        Text("Próxima Pergunta")
                    }
                } else {
                    Button(onClick = { navController.navigate("treasure") }) {
                        Text("Você encontrou o Tesouro!")
                    }
                }
            } else {
                feedback = "Resposta errada, tente novamente!"
            }
        }
    }
}

@Composable
fun TreasureScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Você encontrou o Tesouro!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.popBackStack("home", false)
        }) {
            Text("Voltar para Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TreasureHuntApp()
}