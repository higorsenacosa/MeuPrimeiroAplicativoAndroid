// Define o endereço deste arquivo dentro do seu projeto
package com.example.meuprimeiroaplicativo

// Importações das ferramentas do Android e do Jetpack Compose (cores, textos, layout, etc.)
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meuprimeiroaplicativo.ui.theme.Azul
import com.example.meuprimeiroaplicativo.ui.theme.Vermelho

// Classe que representa a tela principal do aplicativo
class TelaPrincipal : ComponentActivity() {

    // Silencia o aviso de que o padding interno do Scaffold não está sendo usado
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

    // Ponto de partida: executado assim que a tela é aberta
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Configurações padrão do Android na memória

        // Faz o app desenhar em 100% da tela (inclusive atrás da barra de bateria e navegação)
        enableEdgeToEdge()

        // Ponte entre o Android clássico e o Compose: a partir daqui, desenhamos com Kotlin
        setContent {
            // Estrutura base de layout. O systemBarsPadding empurra o conteúdo
            // para baixo da barra de bateria e para cima dos botões virtuais
            Scaffold(Modifier.systemBarsPadding()) {
                // Chama a função que desenha a interface gráfica
                CaixaPrincipal()
            }
        }
    }
}

// Permite visualizar o layout no Android Studio sem precisar rodar no celular
@Preview(showBackground = true)
// Avisa ao compilador que esta função constrói interface gráfica
@Composable
fun CaixaPrincipal() {

    // Contêiner vertical: organiza os itens um embaixo do outro
    Column(modifier = Modifier
        .background(Color(0xFF000000)) // Pinta o fundo da coluna de preto absoluto
        .fillMaxSize() // Faz a coluna ocupar toda a largura e altura da tela
        .verticalScroll(rememberScrollState()) // Ativa a barra de rolagem (scroll)
    ){
        // Variável que guarda a cor atual da linha
        var cor = Azul

        // Laço de repetição que vai rodar 32 vezes (de 1 a 32)
        for(i in 1..32) {

            // Verifica se o resto da divisão por 2 é zero (ou seja, se o número é par)
            if (i % 2 == 0)
                cor = Azul // Linhas pares ficam com a cor Azul
            else
                cor = Vermelho // Linhas ímpares ficam com a cor Vermelha

            // Contêiner horizontal para cada uma das 32 linhas
            Row(
                modifier = Modifier
                    .fillMaxWidth() // Faz a linha ocupar toda a largura da tela
                    .height(32.dp) // Define a altura exata de 32dp para cada linha
                    .background(cor) // Pinta o fundo da linha com a cor definida no if/else acima
            ) {
                // Imprime o número atual do loop dentro da linha
                Text(text = "${i}")
            }
        }
    }
}