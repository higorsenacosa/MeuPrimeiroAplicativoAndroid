// Define que este arquivo pertence ao pacote de temas do seu aplicativo
package com.example.meuprimeiroaplicativo.ui.theme

// Importações necessárias para configurar as fontes, tamanhos e estilos de texto
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Cria um conjunto de estilos de texto (Tipografia) para o Material Design 3.
// Essa variável 'Typography' é usada lá no arquivo Theme.kt
val Typography = Typography(

    // Define o estilo padrão para textos comuns (textos de corpo/parágrafos grandes)
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Usa a fonte padrão do sistema Android (geralmente Roboto)
        fontWeight = FontWeight.Normal,  // Define a espessura da fonte como "Normal" (sem negrito)
        fontSize = 16.sp,                // Define o tamanho da fonte em 'sp' (tamanho que respeita as configurações de visão do celular do usuário)
        lineHeight = 24.sp,              // Define a altura da linha (espaço entre uma linha e outra num texto de várias linhas)
        letterSpacing = 0.5.sp           // Define o espaçamento entre as letras da palavra
    )

    /*
    Aqui estão outros estilos de texto padrão que o Android deixa comentados.
    Você pode descomentar e alterar para personalizar os títulos e textos pequenos do seu app:

    // titleLarge é usado para textos maiores, como Títulos de telas ou de seções
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // labelSmall é muito usado para textos bem pequenos, como legendas e botões
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium, // Medium é um pouquinho mais grosso que o Normal
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)