package com.yoenas.movietvshow.utils

import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.remote.response.GenresItem
import com.yoenas.movietvshow.data.remote.response.MoviesItem
import com.yoenas.movietvshow.data.remote.response.TvShowsItem

object DataDummy {
    fun generateDataMoviesDummy(): List<MovieTvShow> {
        val listMovies = ArrayList<MovieTvShow>()

        listMovies.add(
            MovieTvShow(
                1,
                457,
                "Spider-Man: No Way Home",
                "2021",
                "Action, Adventure, Science Fiction",
                148,
                8.4,
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                2,
                2345,
                "Encanto",
                "2021",
                "Animation, Comedy, Family, Fantasy",
                102,
                7.8,
                "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                3,
                789,
                "Resident Evil: Welcome to Raccoon City",
                "2021",
                "Horror, Action, Science Fiction, Fantasy",
                107,
                6.1,
                "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sR3iV0Jt080jgvPBtJhs3Tta1y9.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sR3iV0Jt080jgvPBtJhs3Tta1y9.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                4,
                6345,
                "The Matrix Resurrections",
                "2021",
                "Action, Science Fiction",
                148,
                7.0,
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8c4a8kE7PizaGQQnditMmI1xbRp.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                5,
                789,
                "Venom: Let There Be Carnage",
                "2021",
                "Science Fiction, Action, Adventure",
                97,
                7.2,
                "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                6,
                956,
                "Shang-Chi and the Legend of the Ten Rings",
                "2021",
                "Action, Adventure, Fantasy",
                132,
                7.8,
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                7,
                9234,
                "Don't Look Up",
                "2021",
                "Drama, Comedy, Science Fiction",
                143,
                7.3,
                "Two low-level astronomers must go on a giant media tour to warn humankind of an approaching comet that will destroy planet Earth.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/th4E1yqsE8DGpAseLiUrI60Hf8V.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/th4E1yqsE8DGpAseLiUrI60Hf8V.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                8,
                864,
                "Sing 2",
                "2021",
                "Animatino, Comedy, Family, Music",
                110,
                7.5,
                "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                9,
                5346,
                "Clifford the Big Red Dog",
                "2021",
                "Animation, Comedy, Family",
                97,
                7.4,
                "As Emily struggles to fit in at home and at school, she discovers a small red puppy who is destined to become her best friend. When Clifford magically undergoes one heck of a growth spurt, becomes a gigantic dog and attracts the attention of a genetics company, Emily and her Uncle Casey have to fight the forces of greed as they go on the run across New York City. Along the way, Clifford affects the lives of everyone around him and teaches Emily and her uncle the true meaning of acceptance and unconditional love.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oifhfVhUcuDjE61V5bS5dfShQrm.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oifhfVhUcuDjE61V5bS5dfShQrm.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                10,
                6542,
                "Eternals",
                "2021",
                "Action, Adventure, Fantasy, Science Fiction",
                157,
                7.1,
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg"
            )
        )
        listMovies.add(
            MovieTvShow(
                11,
                4536,
                "Spider-Man: No Way Home",
                "2021",
                "Action, Adventure, Science Fiction",
                148,
                8.4,
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                12,
                130,
                "Encanto",
                "2021",
                "Animation, Comedy, Family, Fantasy",
                102,
                7.8,
                "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                13,
                3492,
                "Resident Evil: Welcome to Raccoon City",
                "2021",
                "Horror, Action, Science Fiction, Fantasy",
                107,
                6.1,
                "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sR3iV0Jt080jgvPBtJhs3Tta1y9.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sR3iV0Jt080jgvPBtJhs3Tta1y9.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                14,
                2658,
                "The Matrix Resurrections",
                "2021",
                "Action, Science Fiction",
                148,
                7.0,
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8c4a8kE7PizaGQQnditMmI1xbRp.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                15,
                8567,
                "Venom: Let There Be Carnage",
                "2021",
                "Science, Action, Adventure",
                97,
                7.2,
                "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                16,
                1234,
                "Shang-Chi and the Legend of the Ten Rings",
                "2021",
                "Action, Adventure, Fantasy",
                132,
                7.8,
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                17,
                4578,
                "Don't Look Up",
                "2021",
                "Drama, Comedy, Science Fiction",
                143,
                7.3,
                "Two low-level astronomers must go on a giant media tour to warn humankind of an approaching comet that will destroy planet Earth.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/th4E1yqsE8DGpAseLiUrI60Hf8V.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/th4E1yqsE8DGpAseLiUrI60Hf8V.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                18,
                9734,
                "Sing 2",
                "2021",
                "Animationm, Comedy, Family, Music",
                110,
                7.5,
                "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                19,
                7032,
                "Clifford the Big Red Dog",
                "2021",
                "Animation, Comedy, Family",
                97,
                7.4,
                "As Emily struggles to fit in at home and at school, she discovers a small red puppy who is destined to become her best friend. When Clifford magically undergoes one heck of a growth spurt, becomes a gigantic dog and attracts the attention of a genetics company, Emily and her Uncle Casey have to fight the forces of greed as they go on the run across New York City. Along the way, Clifford affects the lives of everyone around him and teaches Emily and her uncle the true meaning of acceptance and unconditional love.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oifhfVhUcuDjE61V5bS5dfShQrm.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oifhfVhUcuDjE61V5bS5dfShQrm.jpg"
            )
        )

        listMovies.add(
            MovieTvShow(
                20,
                1892,
                "Eternals",
                "2021",
                "Action, Adventure, Fantasy, Science Fiction",
                157,
                7.1,
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg"
            )
        )
        return listMovies
    }

    fun generateDataTvShowsDummy(): List<MovieTvShow> {
        val listTvShows = ArrayList<MovieTvShow>()

        listTvShows.add(
            MovieTvShow(
                1,
                61663,
                "Your Lie in April",
                "2014-10-10",
                "Animation, Drama, Comedy",
                23,
                8.9,
                "Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?",
                "/IGbeFv5Ji4W0x530JcSHiQpamY.jpg",
                "/x6jWDL4H9TaBLGEvyej0qKiirBU.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                2,
                5075,
                "I Am Not an Animal",
                "2004",
                "Animation, Comedy",
                30,
                9.2,
                "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                3,
                1111,
                "Arcane",
                "2021",
                "Animation, Sci-Fi & Fantasy, Action & Adventure, Drama",
                42,
                9.1,
                "Amid the stark discord of twin cities Piltover and Zaun, two sisters fight on rival sides of a war between magic technologies and clashing convictions.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fqldf2t8ztc9aiwn3k6mlX3tvRT.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fqldf2t8ztc9aiwn3k6mlX3tvRT.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                4,
                2222,
                "BTS In the SOOP",
                "2020",
                "Reality",
                80,
                9.0,
                "'In the SOOP BTS ver.' is a reality show, portraying BTS members' everyday life, relaxation, and everything in between, away from the city life. A time of freedom and healing in a place for BTS, and BTS only.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eBsIEKqLMtktw2jpFPa9WTuGyPN.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eBsIEKqLMtktw2jpFPa9WTuGyPN.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                5,
                3333,
                "SK8 the Infinity",
                "2021",
                "Animation, Action & Adventure",
                24,
                9.0,
                "\"S\" is a dangerous, top secret, no-holds-barred downhill skateboarding race down an abandoned mine. When avid skateboarder Reki takes Langa to the mountain where \"S\" is held, Langa, who's never been on a skateboard in his life, finds himself sucked into the world of \"S\", and…?!",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ksb6QlSCsRLr3MNmxc8ojOOLK6V.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ksb6QlSCsRLr3MNmxc8ojOOLK6V.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                6,
                4444,
                "Given",
                "2019",
                "Animation, Drama",
                23,
                9.0,
                "Tightly clutching his Gibson guitar, Mafuyu Satou steps out of his dark apartment to begin another day of his high school life. While taking a nap in a quiet spot on the gymnasium staircase, he has a chance encounter with fellow student Ritsuka Uenoyama, who berates him for letting his guitar's strings rust and break. Noticing Uenoyama's knowledge of the instrument, Satou pleads for him to fix it and to teach him how to play. Uenoyama eventually agrees and invites him to sit in on a jam session with his two band mates: bassist Haruki Nakayama and drummer Akihiko Kaji.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                7,
                5555,
                "The Rising of the Shield Hero",
                "2019",
                "Animation, Action & Adventure, Sci-Fi & Fantasy, Drama",
                24,
                9.0,
                "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6cXf5EDwVhsRv8GlBzUTVnWuk8Z.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6cXf5EDwVhsRv8GlBzUTVnWuk8Z.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                8,
                6666,
                "The Promised Neverland",
                "2019",
                "Animation, Mystery, Sci-Fi & Fantasy, Action & Adventure, Drama",
                23,
                8.9,
                "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \"Mama,\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\n" +
                        "\n" +
                        "However, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgRCpAbtMpk1v8wfdsIph7lPQE.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgRCpAbtMpk1v8wfdsIph7lPQE.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                9,
                7777,
                "Banana Fish",
                "2018",
                "Action & Adventure, Drama, Mystery, Animation",
                23,
                8.9,
                "Nature made Ash Lynx beautiful; nurture made him a cold ruthless killer. A runaway brought up as the adopted heir and sex toy of \"Papa\" Dino Golzine, Ash, now at the rebellious age of seventeen, forsakes the kingdom held out by the devil who raised him. But the hideous secret that drove Ash's older brother mad in Vietnam has suddenly fallen into Papa's insatiably ambitious hands—and it's exactly the wrong time for Eiji Okamura, a pure-hearted young photographer from Japan, to make Ash Lynx's acquaintance...",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1UV5di9UIXwrpCW3xQ4RNli5hEV.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1UV5di9UIXwrpCW3xQ4RNli5hEV.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                10,
                8888,
                "Maid Sama!",
                "2010",
                "Animation, Comedy, Drama",
                25,
                8.9,
                "Misaki Ayuzawa is the first female student council president at a once all-boys school turned co-ed. She rules the school with strict discipline demeanor. But she has a secret—she works at a maid cafe due to her families circumstances. One day the popular A-student and notorious heart breaker Takumi Usui finds out her secret and makes a deal with her to keep it hush from the school in exchange for spending some time with him.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/igkn0M1bgMeATz59LShvVxZNdVd.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/igkn0M1bgMeATz59LShvVxZNdVd.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                11,
                9999,
                "The D'Amelio Show",
                "2021",
                "Reality",
                32,
                9.4,
                "From relative obscurity and a seemingly normal life, to overnight success and thrust into the Hollywood limelight overnight, the D’Amelios are faced with new challenges and opportunities they could not have imagined.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/z0iCS5Znx7TeRwlYSd4c01Z0lFx.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/z0iCS5Znx7TeRwlYSd4c01Z0lFx.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                12,
                1110,
                "I Am Not an Animal",
                "2004",
                "Animation, Comedy",
                30,
                9.2,
                "I Am Not An Animal is an animated comedy series about the only six talking animals in the world, whose cosseted existence in a vivisection unit is turned upside down when they are liberated by animal rights activists.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qG59J1Q7rpBc1dvku4azbzcqo8h.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                13,
                1137,
                "Arcane",
                "2021",
                "Animation, Sci-Fi & Fantasy, Action & Adventure, Drama",
                42,
                9.1,
                "Amid the stark discord of twin cities Piltover and Zaun, two sisters fight on rival sides of a war between magic technologies and clashing convictions.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fqldf2t8ztc9aiwn3k6mlX3tvRT.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fqldf2t8ztc9aiwn3k6mlX3tvRT.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                14,
                7454,
                "BTS In the SOOP",
                "2020",
                "Reality",
                80,
                9.0,
                "'In the SOOP BTS ver.' is a reality show, portraying BTS members' everyday life, relaxation, and everything in between, away from the city life. A time of freedom and healing in a place for BTS, and BTS only.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eBsIEKqLMtktw2jpFPa9WTuGyPN.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eBsIEKqLMtktw2jpFPa9WTuGyPN.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                15,
                3332,
                "SK8 the Infinity",
                "2021",
                "Animation, Action & Adventure",
                24,
                9.0,
                "\"S\" is a dangerous, top secret, no-holds-barred downhill skateboarding race down an abandoned mine. When avid skateboarder Reki takes Langa to the mountain where \"S\" is held, Langa, who's never been on a skateboard in his life, finds himself sucked into the world of \"S\", and…?!",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ksb6QlSCsRLr3MNmxc8ojOOLK6V.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ksb6QlSCsRLr3MNmxc8ojOOLK6V.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                16,
                9888,
                "Given",
                "2019",
                "Animation, Drama",
                23,
                9.0,
                "Tightly clutching his Gibson guitar, Mafuyu Satou steps out of his dark apartment to begin another day of his high school life. While taking a nap in a quiet spot on the gymnasium staircase, he has a chance encounter with fellow student Ritsuka Uenoyama, who berates him for letting his guitar's strings rust and break. Noticing Uenoyama's knowledge of the instrument, Satou pleads for him to fix it and to teach him how to play. Uenoyama eventually agrees and invites him to sit in on a jam session with his two band mates: bassist Haruki Nakayama and drummer Akihiko Kaji.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pdDCcAq8RNSZNk81PXYoHNUPHjn.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                17,
                5665,
                "The Rising of the Shield Hero",
                "2019",
                "Animation, Action & Adventure, Sci-Fi & Fantasy, Drama",
                24,
                9.0,
                "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6cXf5EDwVhsRv8GlBzUTVnWuk8Z.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6cXf5EDwVhsRv8GlBzUTVnWuk8Z.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                18,
                8776,
                "The Promised Neverland",
                "2019",
                "Animation, Mystery, Sci-Fi & Fantasy, Action & Adventure, Drama",
                23,
                8.9,
                "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \"Mama,\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\n" +
                        "\n" +
                        "However, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgRCpAbtMpk1v8wfdsIph7lPQE.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgRCpAbtMpk1v8wfdsIph7lPQE.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                19,
                9889,
                "Banana Fish",
                "2018",
                "Action & Adventure, Drama, Mystery, Animation",
                23,
                8.9,
                "Nature made Ash Lynx beautiful; nurture made him a cold ruthless killer. A runaway brought up as the adopted heir and sex toy of \"Papa\" Dino Golzine, Ash, now at the rebellious age of seventeen, forsakes the kingdom held out by the devil who raised him. But the hideous secret that drove Ash's older brother mad in Vietnam has suddenly fallen into Papa's insatiably ambitious hands—and it's exactly the wrong time for Eiji Okamura, a pure-hearted young photographer from Japan, to make Ash Lynx's acquaintance...",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1UV5di9UIXwrpCW3xQ4RNli5hEV.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1UV5di9UIXwrpCW3xQ4RNli5hEV.jpg"
            )
        )

        listTvShows.add(
            MovieTvShow(
                20,
                3488,
                "Maid Sama!",
                "2010",
                "Animation, Comedy, Drama",
                25,
                8.9,
                "Misaki Ayuzawa is the first female student council president at a once all-boys school turned co-ed. She rules the school with strict discipline demeanor. But she has a secret—she works at a maid cafe due to her families circumstances. One day the popular A-student and notorious heart breaker Takumi Usui finds out her secret and makes a deal with her to keep it hush from the school in exchange for spending some time with him.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/igkn0M1bgMeATz59LShvVxZNdVd.jpg",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/igkn0M1bgMeATz59LShvVxZNdVd.jpg"
            )
        )

        return listTvShows
    }

    fun generateRemoteDataMoviesDummy(): List<MoviesItem> {
        val listMovies = ArrayList<MoviesItem>()

        listMovies.add(
            MoviesItem(
                1,
                "Spider-Man: No Way Home",
                "2021-12-15",
                arrayListOf(
                    GenresItem("Action"),
                    GenresItem("Adventure"),
                    GenresItem("Science Fiction"),
                ),
                148,
                8.4,
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg"
            )
        )
        return listMovies
    }

    fun generateRemoteDataTvShowsDummy(): List<TvShowsItem> {
        val listTvShows = ArrayList<TvShowsItem>()

        listTvShows.add(
            TvShowsItem(
                61663,
                "Your Lie in April",
                "2014-10-10",
                arrayListOf(
                    GenresItem("Animation"),
                    GenresItem("Comedy"),
                    GenresItem("Comedy")
                ),
                listOf(23),
                8.9,
                "Kousei Arima was a genius pianist until his mother's sudden death took away his ability to play. Each day was dull for Kousei. But, then he meets a violinist named Kaori Miyazono who has an eccentric playing style. Can the heartfelt sounds of the girl's violin lead the boy to play the piano again?",
                "/IGbeFv5Ji4W0x530JcSHiQpamY.jpg",
                "/x6jWDL4H9TaBLGEvyej0qKiirBU.jpg"
            )
        )
        return listTvShows
    }



}