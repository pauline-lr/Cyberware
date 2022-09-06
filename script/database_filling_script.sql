INSERT INTO language (name, image_name)
VALUES ('English', 'english.png'),
       ('French', 'french.png');

INSERT INTO category (description, image_name)
VALUES ('brain performance improvement', 'brain.png'),
       ('sight sense improvement', 'ocular_system.png'),
       ('physical endurance improvement', 'circulatory_system.png'),
       ('immune resistance improvement', 'immune_system.png'),
       ('physical reaction improvement', 'nervous_system.png'),
       ('integumentary resistance improvement', 'integumentary_system.png'),
       ('physical resistance improvement', 'skeleton.png'),
       ('hands performance improvement', 'hands.png'),
       ('arms performance improvement', 'arms.png'),
       ('legs performance improvement', 'legs.png');

INSERT INTO category_translation (identifier, name, category, language)
VALUES (11, 'Brain', 1, 1),
       (12, 'Cerveau', 1, 2),

       (21, 'Ocular system', 2, 1),
       (22, 'Système oculaire', 2, 2),

       (31, 'Circulatory system', 3, 1),
       (32, 'Système circulatoire', 3, 2),

       (41, 'Immune system', 4, 1),
       (42, 'Système immunitaire', 4, 2),

       (51, 'Nervous system', 5, 1),
       (52, 'Système nerveux', 5, 2),

       (61, 'Integumentary system', 6, 1),
       (62, 'Système tégumentaire', 6, 2),

       (71, 'Skeleton', 7, 1),
       (72, 'Squelette', 7, 2),

       (81, 'Hands', 8, 1),
       (82, 'Mains', 8, 2),

       (91, 'Arms', 9, 1),
       (92, 'Bras', 9, 2),

       (101, 'Legs', 10, 1),
       (102, 'Jambes', 10, 2);

INSERT INTO item (name, price, description, image_name, category)
VALUES ('Camillo Ram Manager', 14000, 'Instantly restores 30% of RAM.', 'camillo_ram_manager.png', 1),
       ('Ex-Disk', 28000, 'Max RAM +5.', 'ex-disk.png', 1),
       ('Heal-On-Kill', 35000, 'Defeating an enemy restores 10% health.', 'heal-on-kill.png', 1),
       ('Limbic System', 21000, '+25% critical chance.', 'limbic_system_enhancement.png', 1),
       ('Mechatronic Core', 21000, 'Damage dealt to Drones, Androids, and Mechs +50%.', 'mechatronic_core.png', 1),
       ('Memory Boost', 12000, '+3 RAM when you defeat an enemy.', 'memory_boost.png', 1),
       ('Ram Upgrade', 3000, '+0,15 sec RAM recovery rate.', 'ram_upgrade.png', 1),
       ('Self-Ice', 9000, 'Prevents enemy netrunners from hacking you.', 'self-ice.png', 1),
       ('Visual Cortex Support', 21000, 'Critical Damage +45%.', 'visual_cortex_support.png', 1),

       ('Kiroshi Optics MK.1', 1000, 'Enhances vision for scanning.', 'kiroshi_optics_mk.1.png', 2),
       ('Kiroshi Optics MK.2', 3000, 'Enhances vision for scanning.', 'kiroshi_optics_mk.2.png', 2),
       ('Kiroshi Optics MK.3', 5000, 'Enhances vision for scanning.', 'kiroshi_optics_mk.3.png', 2),

       ('Adrenaline Booster', 28000, '+50% stamina when you defeat an enemy.', 'adrenaline_booster.png', 3),
       ('Bioconductor', 14000, 'Cyberware cooldowns -30%.', 'bioconductor.png', 3),
       ('Biomonitor', 42000, 'Restores 100% health when total drops below 15%. Cooldown 120 seconds.', 'biomonitor.png', 3),
       ('Bioplastic Blood Vessels', 14000, 'Health regeneration outside combat +50 per second.', 'bioplastic_blood_vessels.png', 3),
       ('Blood Pump', 35000, 'Activate to instantly restore 90% health. Cooldown 180 seconds.', 'blood_pump.png', 3),
       ('Feedback Circuit', 21000, 'Instantly restores 10% Health after you discharge a fully charged weapon.', 'feedback_circuit.png', 3),
       ('Microgenerator', 7000, 'Release an EMP blast that deals +50% of the target max Health when your own HP drops below 15%.', 'microgenerator.png', 3),
       ('Second Heart', 42000, 'Revives you if your health is fully depleted, completely restoring the meter. Cooldown of 2 minutes.', 'second_heart.png', 3),
       ('Syn-Lungs', 7000, 'Increases Stamina regen by 25.', 'syn-lungs.png', 3),
       ('Tyrosine Injector', 150, 'Increases Breach Protocol timer by 100%.', 'tyrosine_injector.png', 3),

       ('Cataresist', 14000, 'Increases all resistances by 35%.', 'cataresist.png', 4),
       ('Inductor', 20000, 'Getting shocked or affected by EMP effects boosts your Armor by 50% instead of dealing damage.', 'inductor.png', 4),
       ('Detoxifier', 12000, 'Grants full immunity against Poison effects.', 'detoxifier.png', 4),
       ('Metabolic Editor', 25000, 'Getting poisoned restores 12% health per second instead of dealing damage.', 'metabolic_editor.png', 4),
       ('Pain Editor', 28000, 'Reduces all incoming damage by 10%.', 'pain_editor.png', 4),
       ('Shock-N-Awe', 7000, 'When hit, you have a 10% chance to release an electroshock blast dealing damage to nearby enemies equal to 20% of their max health.', 'shock-n-awe.png', 4),

       ('Kerenzikov', 35000, 'Allows you to aim and shoot while dodging. Slows time by 90% for 3,5 sec. When blocking, aiming or attacking during a slide or dodge. Cooldown 5 sec.', 'kerenzikov.png', 5),
       ('Reflex Tuner', 35000, 'Slow time by 80% for 4 sec. when your health drops to 25%. Cooldown 40 seconds.', 'reflex_tuner.png', 5),
       ('Maneuvering System', 3000, 'Allows you to perform dodges in midair.', 'maneuvering_system.png', 5),
       ('Nanorelays', 20000, 'Increases Sandevistan and Kerenzikov duration by 2 sec.', 'nanorelays.png', 5),
       ('Neofiber', 7000, 'Increases evasion by 15%.', 'neofiber.png', 5),
       ('Synaptic Accelerator', 35000, 'Slows time by 50% for 4 sec. when you are detected by enemies. Cooldown 60 sec.', 'synaptic_accelerator.png', 5),

       ('Fireproof Coating', 12000, 'Grants full immunity against burn.', 'fireproof_coating.png', 6),
       ('Grounding Plating', 12000, 'Grants full immunity against shock.', 'grounding_plating.png', 6),
       ('Heat Converter', 25000, 'Burn effects increase the damage you deal by 10% instead of harming you.', 'heat_converter.png', 6),
       ('Optical Camo', 35000, 'Activate to turn almost invisible for 15 seconds, greatly reducing the likelihood of detection. Cooldown 60 seconds.', 'optical_camo.png', 6),
       ('Subdermal Armor', 14000, 'Increases armor by 200.', 'subdermal_armor.png', 6),
       ('Supradermal Weave', 12000, 'Grants full immunity against bleeding.', 'supradermal_weave.png', 6),

       ('Bionic Joints', 10000, 'Recoil kick after shooting with ranged weapons -25%.', 'bionic_joints.png', 7),
       ('Bionic Lungs', 7000, 'Increases Stamina by 60%.', 'bionic_lungs.png', 7),
       ('Dense Marrow', 10000, 'Melee weapon damage +25%, but stamina drain +10%.', 'dense_marrow.png', 7),
       ('Synaptic Signal Optimizer', 28000, 'Max health +60%.', 'synaptic_signal_optimizer.png', 7),
       ('Microrotors', 14000, 'Melee weapon attack speed +25%.', 'microrotors.png', 7),
       ('Microvibration Generator', 25000, 'Melee weapon damage +15%.', 'microvibration_generator.png', 7),
       ('Titanium Bones', 3000, 'Increases carrying capacity by 60%.', 'titanium_bones.png', 7),

       ('Ballistic Coprocessor', 21000, 'Increases the chance to ricochet shots with Power weapons. Bullets ricochet 2 additional time.', 'ballistic_coprocessor.png', 8),
       ('Smart Link', 21000, 'Enables you to use the auto-targeting system in Smart weapons, greatly increasing their efficiency. Chance for Smart bullets to home in on the target +15%; Critical Damage +25%.', 'smart_link.png', 8),

       ('Gorilla Arms', 55250, 'Turns your fists into deadly weapons. Hitting enemies builds a charge that can be released with a strong attack, causing severe damage. 3 universal mod slots available.', 'gorilla_arms.png', 9),
       ('Mantis Blades', 55350, 'Two deadly blades useful for melee combat and to lunge at enemies. 3 universal mod slots available.', 'mantis_blades.png', 9),
       ('Monowire', 55450, 'A self-charging wire that can lash multiple enemies simultaneously, with a surprisingly long range for a melee weapon. Attacking discharges the wire, which recharges when equipped but not in use. 3 universal mod slots available.', 'monowire.png', 9),
       ('Projectile Launch System', 55450, 'A projectile launcher used to fire missiles over long distances. 3 universal mod slots available.', 'projectile_launch_system.png', 9),

       ('Fortified Ankles', 75000, 'Hold jump button to charge the power of the jump, then release to jump. Reduces fall damage in 15%. Enables you to perform hover jumps.', 'fortified_ankles.png', 10),
       ('Lynx Paws', 85000, 'You make 50% less noise when moving.', 'lynx_paws.png', 10),
       ('Reinforced Tendons', 45000, 'Press jump button while in midair to perform a double jump.', 'reinforced_tendons.png', 10);

INSERT INTO customer (first_name, last_name, username, phone_number, address, password, authorities, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES ('Jonathan', 'Smith', 'etu43752@henallux.be', '0465252263', 'mon adresse', '$2a$10$T.K2OXE4fVf67PN448rPCOK0t.OmyKDVrQLweK9eOFq/oIfDPM96y', 'ROLE_ADMIN', true, true, true, true),
       ('Pauline', 'Loréa', 'etu40989@student.henallux.be', '0412589696', 'son adresse', '$2a$10$C./pIY.L2Nk0woU9VywbOud9sZstNV9IGo1irCgRqEIJ30cU7hdkC', 'ROLE_ADMIN', true, true, true, true),
       ('Francoise', 'Dubisy', 'francoise.dubisy@henallux.be', '0411714885', 'son adresse', '$2a$10$oPJcn0GeQSV5hHK3xGMCieiJ2XrM3Sv5HOCvBZrIZO.WEhYWbWF3.', 'ROLE_USER', true, true, true, true);