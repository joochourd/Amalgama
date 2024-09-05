package domain

interface Transformable<T> {
    fun transform():T
    fun getTransformationCost(): Int
}