package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.scrim
                ){
                    val image= painterResource(R.drawable.coffee_high_resolution_logo)
                    val fName= stringResource(R.string.full_name)
                    val tytle= stringResource(R.string.title)
                    val pNo= stringResource(R.string.p_no)
                    val sH= stringResource(R.string.sh)
                    val email= stringResource(R.string.e_mail)
                    Card(
                        image,fName,tytle,pNo,sH,email
                    )
                }
            }
        }
    }
}

@Composable
fun Card(image: Painter,fName : String ,tytle : String ,pNo : String ,sH : String ,email : String , modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(
        rememberScrollState()
    )) {
        Image(painter = image, contentDescription =null,Modifier.padding(bottom = 6.dp))
        Text(text = fName , color = Color.White, fontWeight = FontWeight.Bold, fontSize = 30.sp,modifier=Modifier.padding(5.dp))
        Text(text = tytle, color = Color.Cyan, fontStyle = FontStyle.Italic)
        val image1= painterResource(id = R.drawable.coffee_high_resolution_logo_white)
        Image(painter = image1, contentDescription = null)
        Column(verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Text(text = pNo, color = Color.White)
            Text(text = sH, color = Color.White,)
            Text(text=email, color = Color.White,modifier=Modifier.padding(bottom=5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        val image= painterResource(R.drawable.coffee_high_resolution_logo)
        val fName= stringResource(R.string.full_name)
        val tytle= stringResource(R.string.title)
        val pNo= stringResource(R.string.p_no)
        val sH= stringResource(R.string.sh)
        val email= stringResource(R.string.e_mail)
        Card(
            image,fName,tytle,pNo,sH,email
        )
    }
}