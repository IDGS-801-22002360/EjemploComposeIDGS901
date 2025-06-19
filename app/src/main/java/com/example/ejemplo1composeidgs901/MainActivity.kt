package com.example.ejemplo1composeidgs901

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            Ejemplo1ComposeIDGS901Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("android18","Es la hermana melliza del Androide Número 17 y una \"androide\" creada a partir de una base humana por el Dr. Gero con el único fin de destruir a Goku."),
    PersonajeTarjeta("android17","Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero, y es por eso que lo odian. Tras su cambio de humano a Androide, le insertaron un chip con el objetivo de destruir a Son Goku, quien en su juventud extermino al Ejército del Listón Rojo. Al considerarse defectuoso porque no quería ser 'esclavo de nadie', el Dr. Gero les había colocado a ambos hermanos, un dispositivo de apagado para detenerlos en cualquier momento de desobediencia, pero cuando el científico los despierta, el rencor y rebeldía de 17 eran tal que se encargó de destruir el control que lo volvería a encerrar y acto seguido mató sin piedad a su propio creador. Su situación se le iría en contra, ya que Cell tenía como misión absorber a 17 y 18 para completar su desarrollo y convertirse en Cell Perfecto."),
    PersonajeTarjeta("android16","Android 16 es un androide gigante conocido por su amor a la naturaleza y la vida."),
    PersonajeTarjeta("androide20","Dr. Gero es el científico loco que creó a los androides 17, 18 y 19."),
    PersonajeTarjeta("broly","Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario. Incluso cuando apenas era un bebé su nivel de poder alcanzaba cifras inmensas que provocaban asombro y preocupación entre los de su raza"),
    PersonajeTarjeta("gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola. Es el primer hijo de Son Goku y Chi-Chi, hermano mayor de Son Goten, esposo de Videl y padre de Pan."),
    PersonajeTarjeta("gogeta","Gogeta es la fusión resultante de Son Goku y Vegeta, cuando realizan la Danza de la Fusión correctamente para enfrentarse a Broly. Su voz es una voz dual que contiene las voces de Goku y Vegeta. Junto con el poder todopoderoso de los dos, con la astucia y perspicacia de Vegeta, y la habilidad pródiga de las artes marciales de Goku, es uno de los guerreros más temibles para desafiar a una pelea.")
)

data class PersonajeTarjeta(val title: String, val body: String)

@Composable
fun MyPersonaje(personaje: PersonajeTarjeta){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row (
            modifier = Modifier.padding(8.dp).background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHeroe(personaje.title.lowercase())
            Personajes(personaje)
        }
    }
}

@Composable
fun Personaje(name: String,color:Color,style:TextStyle,lines:Int=Int.MAX_VALUE){
    Text(text = name, color = color, style = style, maxLines = lines)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    var expand by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(start = 8.dp).clickable { expand = !expand }
    ) {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium
        )
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge,
            if (expand) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun ImagenHeroe(imageName: String){
    val context = LocalContext.current
    val ImageResId = remember (imageName){
        context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }

    Image(
        painter =  painterResource(id = ImageResId),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}


@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>) {
    LazyColumn {
        items(personajes){ personaje ->
            MyPersonaje(personaje)
        }
    }
}


@Composable
fun SaludoCard(name:String, datosCard:String) {
    Row () {
        Column {
            Text("Nombre: $name")
            Spacer(modifier = Modifier.padding(8.dp))
            Text("Datos: $datosCard")
        }
    }
}

@Preview()
@Composable
fun PreviewSaludoCard(){
    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()){
        SaludoCard("Android", "personaje")
    }

}