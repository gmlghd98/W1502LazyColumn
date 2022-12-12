package kr.ac.kumoh.s20170523.w1502lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20170523.w1502lazycolumn.ui.theme.W1502LazyColumnTheme

class MainActivity : ComponentActivity() {
    data class Song(var title: String, var singer: String)
    private val songs = mutableListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeat(20) {
            songs.add(Song("테스형", "나훈아"))
            songs.add(Song("새삥", "지코"))
            songs.add(Song("소주 한 잔", "임창정"))
        }

        @Composable
        fun SongItem(song:Song) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(Color(255, 210, 210))
                    .padding(8.dp)
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
                items(songs) { song ->
                   SongItem(song)
                }
            }
        }
        @Composable
        fun MyApp() {
            W1502LazyColumnTheme {
                List()
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