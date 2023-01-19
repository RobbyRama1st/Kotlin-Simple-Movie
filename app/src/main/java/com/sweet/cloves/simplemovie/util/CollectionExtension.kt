package com.sweet.cloves.simplemovie.util

object CollectionExtension {

    const val SORTED_DESCENDING = 0
    const val SORTED_ASCENDING = 1

    /** replace an element with new value */
    fun <E> Iterable<E>.replace(old: E, new: E) = map { if (it == old) new else it }

    /** update an element from array by index */
    fun <E> Iterable<E>.update(index: Int, elem: E) = mapIndexed { i, existing ->  if (i == index) elem else existing }

    /**
     * remove duplicates data from list with distinct by given selector
     */
    fun <T> Iterable<T>.appendWithoutDuplicates(indexFromZero: Boolean = true, newList: List<T>): List<T> {
        val tempArr = this.toMutableList()
        if (indexFromZero) {
            tempArr.addAll(0, newList)
        } else {
            tempArr.addAll(newList)
        }
        return tempArr.distinct()
    }

    /**
     * remove duplicates data from list with distinct by given selector
     */
    inline fun <T, K> Iterable<T>.appendWithoutDuplicates(indexFromZero: Boolean = true, newList: List<T>, distinct: (T) -> K): List<T> {
        val tempArr = this.toMutableList()
        if (indexFromZero) {
            tempArr.addAll(0, newList)
        } else {
            tempArr.addAll(newList)
        }
        return tempArr.distinctBy(distinct)
    }

    /**
     * remove duplicates data from list and sort
     */
    inline fun <T, K, R: Comparable<R>> Iterable<T>.appendWithoutDuplicates(indexFromZero: Boolean = true, newList: List<T>, distinct: (T) -> K, sortedBy: Int = SORTED_ASCENDING, crossinline sorted: (T) -> R?): List<T> {
        val tempArr = this.toMutableList()
        if (indexFromZero) {
            tempArr.addAll(0, newList)
        } else {
            tempArr.addAll(newList)
        }
        return if (sortedBy == SORTED_ASCENDING) {
            tempArr.sortedBy(sorted)
        } else {
            tempArr.sortedByDescending(sorted)
        }.distinctBy {
            distinct(it)
        }
    }
}
