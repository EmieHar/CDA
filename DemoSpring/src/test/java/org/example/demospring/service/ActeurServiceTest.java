package org.example.demospring.service;

import org.example.demospring.model.Acteur;
import org.example.demospring.repository.ActeurRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ActeurServiceTest {

    @Mock
    private ActeurRepo acteurRepo;

    @InjectMocks
    private ActeurService acteurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getOne() {
        // Arrange
        Acteur expectedActeur = new Acteur();
        expectedActeur.setId(1);
        expectedActeur.setNom("Belmondo");
        expectedActeur.setPrenom("Jean-Paul");

        when(acteurRepo.findById(1)).thenReturn(Optional.of(expectedActeur));

        // Act
        Optional<Acteur> actualActeur = acteurService.getOne(1);

        // Assert
        assertTrue(actualActeur.isPresent(), "L'acteur devrait être présent");
        assertEquals("Belmondo", actualActeur.get().getNom(), "Le nom devrait être Belmondo");
        assertEquals("Jean-Paul", actualActeur.get().getPrenom(), "Le prénom devrait être Jean-Paul");
    }
}