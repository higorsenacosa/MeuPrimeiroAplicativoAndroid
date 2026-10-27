// Define que este arquivo pertence ao pacote de temas do seu aplicativo
package com.example.meuprimeiroaplicativo.ui.theme

// Importações necessárias para gerenciar as cores, temas e versão do Android
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Cria a paleta de cores que será usada quando o celular estiver no Modo Escuro (Dark Mode)
private val DarkColorScheme = darkColorScheme(
    primary = Roxo,      // Cor principal do app (ex: botões de destaque, topo da tela)
    secondary = Cinza,   // Cor secundária (ex: botões menos importantes, ícones)
    tertiary = Azul      // Cor de detalhes extras
)

// Cria a paleta de cores que será usada quando o celular estiver no Modo Claro (Light Mode)
private val LightColorScheme = lightColorScheme(
    primary = Roxo,
    secondary = Cinza,
    tertiary = Azul

    /*
    Aqui estão outras cores padrão que você pode descomentar e alterar se quiser:
    background = Color(0xFFFFFBFE), // Cor de fundo geral do app
    surface = Color(0xFFFFFBFE),    // Cor de fundo de "superfícies" como Cartões (Cards)
    onPrimary = Color.White,        // Cor do texto que fica EM CIMA da cor primary
    onSecondary = Color.White,      // Cor do texto que fica EM CIMA da cor secondary
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F), // Cor do texto que fica no fundo geral
    onSurface = Color(0xFF1C1B1F),
    */
)

// Função que encapsula o tema do seu aplicativo. Tudo que estiver dentro dela receberá essas cores.
@Composable
fun MeuPrimeiroAplicativoTheme(
    // Verifica automaticamente se o celular do usuário está no modo escuro
    darkTheme: Boolean = isSystemInDarkTheme(),

    // Ativa as "Cores Dinâmicas" do Material You (disponível do Android 12 em diante).
    // Isso faz o app pegar as cores do papel de parede do usuário.
    dynamicColor: Boolean = true,

    // O conteúdo do seu aplicativo (suas telas) que será abraçado por este tema
    content: @Composable () -> Unit
) {
    // Decide qual paleta de cores usar com base nas configurações do celular
    val colorScheme = when {
        // Se a cor dinâmica estiver ativada e o Android for 12 (S) ou superior...
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            // ...pega as cores baseadas no papel de parede (claro ou escuro)
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // Caso contrário, se estiver no modo escuro, usa a sua paleta Dark feita lá em cima
        darkTheme -> DarkColorScheme

        // Se não for nada disso, usa a sua paleta Light padrão
        else -> LightColorScheme
    }

    // Aplica as cores escolhidas, as fontes (Typography) e renderiza as suas telas (content)
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Puxa as fontes definidas no arquivo Type.kt
        content = content
    )
}