package com.tambapps.http.client.response

/**
 * Class representing headers of an Http response
 */
class HttpHeaders(map: Map<String, List<String>>) {
    /**
     * Get all the headers and there value in form of a map
     * @return the map representing the headers
     */
    private val map: Map<String, List<String>> = map.toMap()

    /**
     * Get the first value associated with the given header name
     * @param name the name of the header
     * @return the first value associated with the given header name
     */
    operator fun get(name: String?): String? {
        val values = map[name]
        return values?.get(0)
    }

    // for Groovy
    fun getAt(name: String?): String? {
        return get(name)
    }

    /**
     * Returns whether the header with the given name has at least one value
     * @param name the  name of the header
     * @return if the header has a value
     */
    fun hasValue(name: String?): Boolean {
        val values = map[name]
        return values != null && values.isNotEmpty()
    }

    /**
     * Get all the values associated with the given header name
     * @param name the name of the header
     * @return all the values associated with the given header name
     */
    fun getAllValues(name: String?): List<String> {
        return map[name] ?: emptyList()
    }

    override fun toString(): String {
        return map.toString()
    }

    companion object {
        const val ACCEPT_HEADER = "Accept"
        const val CONTENT_TYPE_HEADER = "Content-Type"
        const val JSON_TYPE = "application/json"
    }

}