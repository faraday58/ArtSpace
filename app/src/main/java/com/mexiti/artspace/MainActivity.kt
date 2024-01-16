package com.mexiti.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mexiti.artspace.ui.theme.ArtSpaceTheme
import com.mexiti.artspace.ui.theme.BlueBackText
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpacePreview()
        }
    }
}


@Composable
fun imageDescriptionAndButton(modifier: Modifier = Modifier  ){
    var result by remember{
        mutableStateOf(1)
    }

    var imageResource = when(result){
        1 -> R.drawable.owen_scott_8am_light1
        2 -> R.drawable.pexels_chait_goli
        3 -> R.drawable.toa_heftiba
        else -> R.drawable.felix_vallotton
    }

    var titleResource = when(result){
        1 -> R.string.Art_Work_Title_owen
        2 -> R.string.Art_Work_Title_chait
        3 -> R.string.Art_Work_Title_toa
        else -> R.string.Art_Work_Title_felix
    }

    var artistResource = when(result){
        1 -> R.string.Art_Work_Artist_owen
        2 -> R.string.Art_Work_Artist_chait
        3 -> R.string.Art_Work_Artist_toa
        else -> R.string.Art_Work_Artist_felix

    }

    var yearResource = when(result){
        1 -> R.string.Art_Work_Year_owen
        2 -> R.string.Art_Work_Year_chait
        3 -> R.string.Art_Work_Year_toa
        else -> R.string.Art_Work_Year_felix
    }



    Surface (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

    ){


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround

    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Light Flowers",
            modifier = Modifier
                .width(300.dp)
                .height(400.dp)
                .border(
                    BorderStroke(30.dp, Color.White)
                )
            )
        showDescription(
            ArtworkTitle = stringResource(id = titleResource) ,
            ArtworkArtist = stringResource(id = artistResource) ,
            ArtWorkYear = stringResource(id = yearResource)
        )

        Row(){
            Button(modifier = Modifier.
            weight(0.5F),
                onClick = {
                    if (result > 1)
                        result --

                }
            ) {
                Text(text = "Previous")
            }

            Spacer(
                modifier = Modifier.width(40.dp)
            )

            Button(
                modifier = Modifier.
                weight(0.5F),
                onClick = {
                    if ( result < 4)
                        result ++
                }) {
                Text(text = "Next")
            }
        }
      }
    }
    
}


@Composable
fun showDescription(ArtworkTitle: String, ArtworkArtist: String,ArtWorkYear: String, modifier: Modifier = Modifier) {
    Column(
        //Modifier.padding(15.dp)
        Modifier
            .background(BlueBackText)

    ) {
        Text(
            text = ArtworkTitle,
            fontSize = 23.sp,
            modifier = Modifier.
            padding( start = 15.dp, top = 15.dp,end = 15.dp   )
        )
        Text(
            buildAnnotatedString {
                withStyle( style = SpanStyle( fontWeight = FontWeight.Bold )){
                    append("$ArtworkArtist")
                }
                append(" ($ArtWorkYear)")
            },
            modifier = Modifier
                .padding(start = 15.dp, end= 15.dp, bottom = 15.dp)

        )
        Spacer(modifier = Modifier.height(10.dp))
    }

}
/*
@Composable
fun ButtonsPrevieousAndNext(result:Int, modifier: Modifier = Modifier){
    Row(){
        Button(modifier = Modifier.
                weight(0.5F),
            onClick = {
                result --

            }
        ) {
            Text(text = "Previous")
        }

        Spacer(
            modifier = Modifier.width(40.dp)
        )

        Button(
            modifier = Modifier.
            weight(0.5F),
            onClick = {
                result ++
            }) {
            Text(text = "Next")
        }
    }
}
*/

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        /*
        showDescription(
            ArtworkTitle = "Still Life of Blue Rose and Other Flowers",
            ArtworkArtist = "Owen Scott" ,
            ArtWorkYear = "2021" )

    }*/
       // ButtonsPrevieousAndNext()
        imageDescriptionAndButton()

    }
}