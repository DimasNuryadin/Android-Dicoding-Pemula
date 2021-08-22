package com.example.proyekakhir

object PresetData {
    private val presetName = arrayOf("Orange and Teal",
        "Amber",
        "Black & White",
        "Faded",
        "Genesis",
        "HDR",
        "Kyoto",
        "Moody",
        "Pine",
        "Rustic Weeding",
        "Cinder",
        "Travel",
        "Travel Film"
        )

    private val presetDetail = arrayOf("Preset ini dapat memberikan foto anda konversi orange dengan kontras tinggi yang indah, sehingga membuat foto tampak lebih hangat",
        "Preset ini dapat mengubah warna suhu lebih soft dan sedikit gelap sehingga preset ini cocok untuk foto berkemah",
        "Preset ini dapat mengubah semua warna menjadi hitam dan putih sehingga foto akan terlihat elegan",
        "Preset ini memberikan efek lebih cerah sehingga foto terkesan happy dan cocok untuk foto didaerah taman",
        "Preset Genesis ini dibuat untuk memberikan efek gelap, preset ini cocok untuk foto yang terlihat brightnestnya terlalu tinggi",
        "Preset HDR ini membuat foto lebih fokus pada objek dan sisanya akan diblur, dan kontrasnya lebigtinggi",
        "Preset Kyoto ini membuat warna foto terlihat lebih solid dan cocok dipakai untuk foto tentang kebudayaan",
        "Preset Moody ini membuat warna foto lebih contrast dan warnanya diturunkan sehingga membuat foto lebih elegan",
        "Preset ini Pine ini dibuat untuk foto yang memperlihatkan keindahan alam dan membuat suhu lebih dingin",
        "Preset ini membuat warna putih lebih cerah dan warna coklat yang dinaikan, cocok untuk foto weeding yang temanya hitam dan coklat",
        "Preset Cinder ini meningkatkan warna kuning terihat lebih gelap sehingga warna yang dihasilkan membuat foto terlihat seperti sunset",
        "Preset ini Travel ini cocok untuk foto yang sedang berlibur diperkotaan dan foto ini seperti memiliki dua layer",
        "Preset ini Travel Film ini cocok untuk foto iklan perfileman dan membuat foto lebih terkesan nyata"
        )

    private val presetImages = intArrayOf(R.drawable.orange_teal,
        R.drawable.amber,
        R.drawable.black_white,
        R.drawable.faded,
        R.drawable.genesis,
        R.drawable.hdr,
        R.drawable.kyoto,
        R.drawable.moody,
        R.drawable.pine,
        R.drawable.rustic_weeding,
        R.drawable.cinder,
        R.drawable.travel,
        R.drawable.travel_film
    )
    val listData: ArrayList<Preset>
        get() {
            val list = arrayListOf<Preset>()
            for (position in presetName.indices) {
                val preset = Preset()
                preset.name = presetName[position]
                preset.detail = presetDetail[position]
                preset.photo = presetImages[position]
                list.add(preset)
            }
            return list
        }
}