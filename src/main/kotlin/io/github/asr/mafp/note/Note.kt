package io.github.asr.mafp.note

import org.bukkit.Bukkit
import org.bukkit.Instrument
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import java.lang.RuntimeException

fun Player.playNote(instrument: Instrument, note: org.bukkit.Note) {
    this.playNote(this.location, instrument, note)
}

fun Player.playNote(plugin: Plugin, instrument: Instrument, note: org.bukkit.Note, beat: Double, next: () -> Unit) {
    this.playNote(instrument, note)
    Bukkit.getScheduler().runTaskLater(plugin, Runnable {
        next.invoke()
    }, (20 * beat).toLong())
    this.playNote(this.location, instrument, note)
}

fun waitNote(plugin: Plugin, beat: Double, next: () -> Unit) {
    Bukkit.getScheduler().runTaskLater(plugin, Runnable {
        next.invoke()
    }, (20 * beat).toLong())
}

enum class Note(private val tone: org.bukkit.Note.Tone, private val sharped: Boolean) {
    C(org.bukkit.Note.Tone.C, false),
    CS(org.bukkit.Note.Tone.C, true),
    D(org.bukkit.Note.Tone.D, false),
    DS(org.bukkit.Note.Tone.D, true),
    E(org.bukkit.Note.Tone.E, false),
    F(org.bukkit.Note.Tone.F, false),
    FS(org.bukkit.Note.Tone.F, true),
    G(org.bukkit.Note.Tone.G, false),
    GS(org.bukkit.Note.Tone.G, true),
    A(org.bukkit.Note.Tone.A, false),
    AS(org.bukkit.Note.Tone.A, true),
    B(org.bukkit.Note.Tone.B, false);

    fun toBukkitNote(octave: Int): org.bukkit.Note {
        if (octave > 1) {
            throw RuntimeException("Octave can't be 2 or bigger than 2!")
        } else if (octave < 0) {
            throw RuntimeException("Octave can't be smaller than 0!")
        } else {
            return org.bukkit.Note(octave, tone, sharped)
        }
    }
}