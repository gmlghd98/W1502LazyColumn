package kr.ac.kumoh.s20170523.w1502lazycolumn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kr.ac.kumoh.s20170523.w1502lazycolumn.ui.theme.W1502LazyColumnTheme

class MainActivity : ComponentActivity() {
    data class Song(var title: String, var singer: String)
    private val songs = mutableStateListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //repeat(20) {
            songs.add(Song("테스형", "나훈아"))
            songs.add(Song("새삥", "지코"))
            songs.add(Song("소주 한 잔", "임창정"))
        //}

        @Composable
        fun SongItem(index: Int,song:Song) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(255, 210, 210))
                    .padding(8.dp)
                    .clickable {
                        Toast
                            .makeText(
                                application,
                                song.title,
                                Toast.LENGTH_LONG
                            )
                            .show()
                    }
            ) {
                AsyncImage(
                    model = "https://picsum.photos/300/300?random=$index",
                    contentDescription = "노래 앨범 이미지",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        //    .clip(CircleShape),
                        .clip(RoundedCornerShape(percent = 10)),
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(song.title, fontSize = 30.sp)
                Text(song.singer, fontSize = 20.sp)
            }
        }

        @Composable
        fun List() {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(songs) { index, song ->
                   SongItem(index, song)
                }
            }
        }
        @Composable
        fun MyApp() {
            W1502LazyColumnTheme {
                Column {
                    Button(
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp),
                        onClick = {
                        songs.add(Song("내가 아니라도", "주호"))
                        }
                    ) {
                        Text("추가")
                    }
                    List()
                }
            }
        }
        setContent {
            MyApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    W1502LazyColumnTheme {
//        MyApp()
//    }
}