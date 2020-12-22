# RickAndMorty - Kotlin

![rivkandmorty](https://user-images.githubusercontent.com/75754448/102901222-a7118780-446d-11eb-8eb8-1013796eb76c.png)

The project was created in activities.After clicking on the "tile" you will be taken to the second layout. 

The data was taken from
https://rickandmortyapi.com/api/character/?page=1

### Gif's 💡

![ezgif com-gif-maker (6)](https://user-images.githubusercontent.com/75754448/102908816-43408c00-4478-11eb-9211-b4a5c5742a97.gif)


### Color
The color of the image depend on the characters status, Alive - Green, Dead - Red, Unknown - Gray.

Object created
->
```Kotlin
object RickAndMortyStatus{
fun getStatusColor(status:String) : Int{
    return when(status){
    "unknown" -> R.color.color1
    "Dead" -> R.color.color2
    "Alive" -> R.color.color3
    else -> R.color.Black
}
}
}
```
 And going to RecyclerViewAdapter
 
```Kotlin
viewStatus.setBackgroundColor(ContextCompat.getColor(
context, RickAndMortyStatus.getStatusColor(data.status)
```

The same in SingleCharacterActivity
```Kotlin
imageThumbSingle.setBackgroundColor(
ContextCompat.getColor(
this, RickAndMortyStatus.getStatusColor(it.status)
```

### Data

Data displayed from the first screen on the RecyclerViewAdapter (item_character.xml)

```Kotlin
fun bind(data: CharacterData, listener: CharactersInterface){
with(itemView){
txtName.text = data.name
txtSpecies.text = data.species
txtStatus.text = data.status
txtGendere.text = data.gender

val url = data.image
Glide.with(context)
.load(url)
.into(imageThumb)
[...]
}
}
```
Second screen SingleActivityCharacter (activity_single_character.xml)

```Kotlin
private fun updateUI(){
viewModel.characterData.observe(this, Observer{
if(it != null){
txtNameSingle.text = it.name
txtLocationSingle.text = it.location.name
txtSpeciesSingle.text = it.species
txtOriginSingle.text = it.origin.name

Glide.with(this)
.load(it.image.circleCrop()
.into(imageThumbSingle)
[...]
}
}
```

