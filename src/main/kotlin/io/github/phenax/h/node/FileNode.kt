package io.github.phenax.h.node

import java.io.File

/**
 * DOM node for rendering file contents as string
 * 
 * @param filePath        Path to the file to read
 * @param loadOnCreate    If true, loads the file into memory when initiated
 */
class FileNode(val filePath: String, val loadOnCreate: Boolean): DOMNode() {

	// Loaded file contents
	private val _fileContents = if(loadOnCreate) _readFile() else ""

	// Read the file as string
	private fun _readFile(): String {
		return File(filePath)
			.inputStream()
			.bufferedReader()
			.use { it.readText() }
	}

	override fun toHtml(): String {
		return if(loadOnCreate) _fileContents else _readFile()
	}
}
