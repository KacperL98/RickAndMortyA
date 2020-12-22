# RickAndMorty - Kotlin

![rivkandmorty](https://user-images.githubusercontent.com/75754448/102901222-a7118780-446d-11eb-8eb8-1013796eb76c.png)

The project was created in activities.After clicking on the "tile" you will be taken to the second layout. 

The data was taken from
https://rickandmortyapi.com/api/character/?page=1

<div class="text-white bg-blue mb-2">
bvsbvbsivb
</div>

### Gif's 💡


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

Data displayed from the first screen on the adapter

![Screenshot_20201222-165047_RickAndMortyA](https://user-images.githubusercontent.com/75754448/102907546-7da92980-4476-11eb-9f7a-dfa07832b892.jpg)

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
Secon screen
![Screenshot_20201222-165052_RickAndMortyA](https://user-images.githubusercontent.com/75754448/102908033-2bb4d380-4477-11eb-946f-03da08a6f6b8.jpg)

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

