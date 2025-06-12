package com.example.ejemplo1composeidgs901

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            Ejemplo1ComposeIDGS901Theme {
                SaludoCard("Marco", "Personajes DB")
            }
        }
    }
}

data class Personajes(val title: String, val body: String)

private val tarjetas: List<Any> = listOf(
    Personajes("Android 18","Es la hermana melliza del Androide Número 17 y una \"androide\" creada a partir de una base humana por el Dr. Gero con el único fin de destruir a Goku."),
    Personajes("Android 17","Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero, y es por eso que lo odian. Tras su cambio de humano a Androide, le insertaron un chip con el objetivo de destruir a Son Goku, quien en su juventud extermino al Ejército del Listón Rojo. Al considerarse defectuoso porque no quería ser 'esclavo de nadie', el Dr. Gero les había colocado a ambos hermanos, un dispositivo de apagado para detenerlos en cualquier momento de desobediencia, pero cuando el científico los despierta, el rencor y rebeldía de 17 eran tal que se encargó de destruir el control que lo volvería a encerrar y acto seguido mató sin piedad a su propio creador. Su situación se le iría en contra, ya que Cell tenía como misión absorber a 17 y 18 para completar su desarrollo y convertirse en Cell Perfecto."),
    Personajes("Android 16","Android 16 es un androide gigante conocido por su amor a la naturaleza y la vida."),
    Personajes("Android 20 (Dr. Gero)","Dr. Gero es el científico loco que creó a los androides 17, 18 y 19."),
    Personajes("Broly","Broly es un Saiyajin que posee un poder gigantesco e incontrolable, el cual se manifiesta en toda su magnitud cuando se convierte en el Super Saiyajin Legendario. Incluso cuando apenas era un bebé su nivel de poder alcanzaba cifras inmensas que provocaban asombro y preocupación entre los de su raza"),
    Personajes("Gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola. Es el primer hijo de Son Goku y Chi-Chi, hermano mayor de Son Goten, esposo de Videl y padre de Pan."),
    Personajes("Gogeta","Gogeta es la fusión resultante de Son Goku y Vegeta, cuando realizan la Danza de la Fusión correctamente para enfrentarse a Broly. Su voz es una voz dual que contiene las voces de Goku y Vegeta. Junto con el poder todopoderoso de los dos, con la astucia y perspicacia de Vegeta, y la habilidad pródiga de las artes marciales de Goku, es uno de los guerreros más temibles para desafiar a una pelea.")
)

@Composable
fun MyPersonaje(personajes: Personajes){
    Row {
        ImagenPersonaje(personajes.title.lowercase())

    }
}



@Composable
fun Personajes(personajes: Personajes){
    Column {
        Text(personajes.title)
        Text(personajes.body)
    }
}

@Composable
fun Personaje(datosCard: String){
    Text(datosCard)
}

@Composable
fun ImagenPersonaje(name: String){
    Image(
        painter =  painterResource(id = R.drawable.dbpixel),
        contentDescription = "Logo DP API",
        Modifier.size(100.dp)
    )
}


@Composable
fun Tarjeta(personajes: List<Personajes>) {
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

@Preview
@Composable
fun PreviewSaludoCard() {
    Ejemplo1ComposeIDGS901Theme {
        SaludoCard("Marco", "Personajes DB")
    }
}