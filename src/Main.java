
import DataStructures.NgramGraph;
import Lex.English.Tokenizers.EnglishTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayowa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
        
        
        
        
        EnglishTokenizer a = new EnglishTokenizer(
"PROLOGUE\n" +
"How does one describe Artemis Fowl? Various psychiatrists have tried and failed. The main\n" +
"problem is Artemis's own intelligence. He bamboozles every test thrown at him. He has\n" +
"puzzled the greatest medical minds and sent many of them gibbering to their own hospitals.\n" +
"There is no doubt that Artemis is a child prodigy. But why does someone of such brilliance\n" +
"dedicate himself to criminal activities? This is a question that can be answered by only one\n" +
"person. And he delights in not talking.\n" +
"Perhaps the best way to create an accurate picture of Artemis is to tell the by now famous\n" +
"account of his first villainous venture. I have put together this report from first-hand\n" +
"interviews with the victims, and as the tale unfolds you will realize that this was not easy.\n" +
"The story began several years ago at the dawn of the twenty-first century. Artemis Fowl had\n" +
"devised a plan to restore his family's fortune. A plan that could topple civilizations and plunge\n" +
"the planet into a cross-species war.\n" +
"He was twelve years old at the time ...\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"7\n" +
"CHAPTER 1: THE BOOK\n" +
"HO Chi Minh City in the summer. Sweltering by anyone's standards. Needless to say, Artemis\n" +
"Fowl would not have been willing to put up with such discomfort if something extremely\n" +
"important had not been at stake. Important to the plan.\n" +
"Sun did not suit Artemis. He did not look well in it. Long hours indoors in front of the\n" +
"monitor had bleached the glow from his skin. He was white as a vampire and almost as testy\n" +
"in the light of day.\n" +
"'I hope this isn't another wild-goose chase, Butler,' he said, his voice soft and clipped.\n" +
"'Especially after Cairo.'\n" +
"It was a gentle rebuke. They had travelled to Egypt on the word of Butler's informant.\n" +
"'No, sir. I'm certain this time. Nguyen is a good man.'\n" +
"'Hmm,' droned Artemis, unconvinced. Passers-by would have been amazed to hear the large\n" +
"Eurasian refer to the boy as sir. This was, after all, the third millennium. But this was no\n" +
"ordinary relationship, and these were no ordinary tourists.\n" +
"They were sitting outside a kerbside cafe on Dong Khai Street, watching the local teenagers\n" +
"circle the square on mopeds.\n" +
"Nguyen was late, and the pathetic patch of shade provided by the umbrella was doing little to\n" +
"improve Artemis's mood. But this was just his daily pessimism. Beneath the sulk was a spark\n" +
"of hope. Could this trip actually yield results? Would they find the Book? It was too much to\n" +
"hope for.\n" +
"A waiter scurried to their table.\n" +
"'More tea, sirs?' he asked, head bobbing furiously.\n" +
"Artemis sighed. 'Spare me the theatrics and sit down.'\n" +
"The waiter turned instinctively to Butler, who was, after all, the adult.\n" +
"'But, sir, I am the waiter.'\n" +
"Artemis tapped the table for attention.\n" +
"'You are wearing handmade loafers, a silk shirt and three gold signet rings. Your English has\n" +
"a tinge of Oxford about it and your nails have the soft sheen of the recently manicured. You\n" +
"are not a waiter. You are our contact, Nguyen Xuan, and you have adopted this pathetic\n" +
"disguise to discreetly check for weaponry.'\n" +
"Nguyen's shoulders sagged. 'It is true. Amazing.'\n" +
"'Hardly. A ragged apron does not a waiter make.'\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"8\n" +
"Nguyen sat, pouring some mint tea into a tiny china cup.\n" +
"'Let me fill you in on the weapons status,' continued Artemis. 'I am unarmed. But Butler here,\n" +
"my ... ah ... butler, has a Sig Sauer in his shoulder holster, two shrike throwing knives in his\n" +
"boots, a derringer two-shot up his sleeve, garrotte wire in his watch and three stun grenades\n" +
"concealed in various pockets. Anything else, Butler?'\n" +
"'The cosh, sir.'\n" +
"'Oh yes. A good old ball-bearing cosh stuffed down his shirt.'\n" +
"Nguyen brought the cup trembling to his lips.\n" +
"'Don't be alarmed, Mister Xuan,' smiled Artemis. 'The weapons will not be used on you.'\n" +
"Nguyen didn't seem reassured.\n" +
"'No,' continued Artemis. 'Butler could kill you a hundred different ways without the use of his\n" +
"armoury. Though I'm sure one would be quite sufficient.'\n" +
"Nguyen was by now thoroughly spooked. Artemis generally had that effect on people. A pale\n" +
"adolescent speaking with the authority and vocabulary of a powerful adult. Nguyen had heard\n" +
"the name Fowl before - who hadn't in the international underworld? - but he'd assumed he'd\n" +
"be dealing with Artemis Senior, not this boy. Though the word 'boy' hardly seemed to do this\n" +
"gaunt individual justice. And the giant, Butler. It was obvious that he could snap a man's\n" +
"backbone like a twig with those mammoth hands. Nguyen was starting to think that no\n" +
"amount of money was worth another minute in this strange company.\n" +
"'And now to business,' said Artemis, placing a micro recorder on the table. 'You answered our\n" +
"web advertisement.'\n" +
"Nguyen nodded, suddenly praying his information was accurate.\n" +
"'Yes, Mister ... Master Fowl. What you're looking for ... I know where it is.'\n" +
"'Really? And am I supposed to take your word for this? You could be walking me straight into\n" +
"an ambush. My family is not without enemies.'\n" +
"Butler snatched a mosquito out of the air beside his employer's ear.\n" +
"'No, no,' said Nguyen, reaching for his wallet. 'Here, look.'\n" +
"Artemis studied the Polaroid. He willed his heart to maintain a calm beat. It seemed\n" +
"promising, but anything could be faked these days with a PC and flatbed scanner. The picture\n" +
"showed a hand reaching from layered shadows. A mottled green hand.\n" +
"'Hmm,' he murmured. 'Explain.'\n" +
"'This woman. She is a healer, nearTu Do Street. She works in exchange for rice wine. All the\n" +
"time, drunk.'\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"9\n" +
"Artemis nodded. It made sense. The drinking. One of the few consistent facts his research had\n" +
"unearthed. He stood, smoothing the creases from his white polo shirt.\n" +
"'Very well. Lead on, Mister Nguyen.'\n" +
"Nguyen wiped the sweat from his stringy moustache.\n" +
"'Information only. That was the agreement. I don't want any curses on my head.'\n" +
"Butler expertly gripped the informant behind the neck.\n" +
"'I'm sorry, Mister Nguyen, but the time when you had a choice in matters is long past.'\n" +
"Butler steered the protesting Vietnamese to a rented four-wheel drive that was hardly\n" +
"necessary on the flat streets of Ho Chi Minh City, or Saigon as the locals still called it, but\n" +
"Artemis preferred to be as insulated from civilians as possible.\n" +
"The jeep inched forward at a painfully slow rate, made all the more excruciating by the\n" +
"anticipation building in Artemis's chest. He could suppress it no longer. Could they at last be\n" +
"at the end of their quest? After six false alarms across three continents, could this winesodden\n" +
"healer be the gold at the end of the rainbow? Artemis almost chuckled. Gold at the end\n" +
"of the rainbow. He'd made a joke. Now there's something that didn't happen every day.\n" +
"The mopeds parted like fish in a giant shoal. There seemed to be no end to the crowds. Even\n" +
"the alleyways were full to bursting with vendors and hagglers. Cooks dropped fish heads into\n" +
"woks of hissing oil, and urchins threaded their way underfoot, searching for unguarded\n" +
"valuables. Others sat in the shade, wearing out their thumbs on Gameboys.\n" +
"Nguyen was sweating right through his khaki top. It wasn't the humidity, he was used to that.\n" +
"It was this whole cursed situation. He should Ve known better than to mix magic and crime.\n" +
"He made a silent promise that if he got out of this, he would change his ways. No more\n" +
"answering shady Internet requests, and certainly no more consorting with the sons of\n" +
"European crime lords.\n" +
"The jeep could go only so far. Eventually the side streets grew too narrow for the four-wheel\n" +
"drive. Artemis turned to Nguyen. 'It seems we must proceed on foot, Mister Nguyen. Run if\n" +
"you like, but expect a sharp and fatal pain between your shoulder blades.'\n" +
"Nguyen glanced into Butler's eyes. They were a deep blue, almost black. There was no mercy\n" +
"in those eyes. 'Don't worry,' he said. 'I won't run.'\n" +
"They climbed down from the vehicle. A thousand suspicious eyes followed their progress\n" +
"along the steaming alley. An unfortunate pickpocket attempted to steal Butler's wallet. The\n" +
"manservant broke the man's fingers without looking down. They were given a wide berth after\n" +
"that.\n" +
"The alley narrowed to a rutted lane. Sewage and drainpipes fed directly on to the muddy\n" +
"surface. Cripples and beggars huddled on rice-mat islands. Most of the residents of this lane\n" +
"had nothing to spare, with the exception of three.\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"10\n" +
"'Well?' demanded Artemis. 'Where is she?'\n" +
"Nguyen jabbed a finger towards a black triangle beneath a rusted fire escape.\n" +
"'There. Under there. She never comes out. Even to buy rice spirits, she sends a runner. Now,\n" +
"can I go?'\n" +
"Artemis didn't bother answering. Instead he picked his way across the puddled lane to the lee\n" +
"of the fire escape. He could discern furtive movements in the shadows.\n" +
"'Butler, could you hand me the goggles?'\n" +
"Butler plucked a set of night-vision glasses from his belt and placed them in Artemis's\n" +
"outstretched hand. The focus motor buzzed to suit the light.\n" +
"Artemis fixed the glasses to his face. Everything became radioactive green.Taking a deep\n" +
"breath, he turned his gaze to the squirming shadows. Something squatted on a raffia mat,\n" +
"shifting uneasily in the almost non-existent light. Artemis fine-tuned the focus. The figure\n" +
"was small, abnormally so, and wrapped in a filthy shawl. Empty spirit jugs were half-buried\n" +
"in the mud around her. One forearm poked from the material. It seemed green. But then, so\n" +
"did everything else.\n" +
"'Madam,' he said, 'I have a proposition for you.'\n" +
"The figure's head wobbled sleepily.\n" +
"'Wine,' she rasped, her voice like nails on a school board. 'Wine, English.'\n" +
"Artemis smiled. The gift of tongues, aversion to light. Check, check.\n" +
"'Irish, actually. Now, about my proposition?'\n" +
"The healer shook a bony finger craftily. 'Wine first. Then talk.'\n" +
"'Butler?'\n" +
"The bodyguard reached into a pocket and drew out a half-pint of the finest Irish whiskey.\n" +
"Artemis took the bottle and held it teasingly beyond the shadows. He barely had time to\n" +
"remove his goggles when the claw-like hand darted from the gloom to snatch the whiskey. A\n" +
"mottled green hand. There was no doubt.\n" +
"Artemis swallowed a triumphant grin.\n" +
"'Pay our friend, Butler. In full. Remember, Mister Nguyen, this is between us. You don't want\n" +
"Butler to come back, do you?'\n" +
"'No, no, Master Fowl. My lips are sealed.'\n" +
"'They had better be. Or Butler will seal them permanently.'\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"11\n" +
"Nguyen skipped off down the alley, so relieved to be alive that he didn't even bother counting\n" +
"the sheaf of US currency. Most unlike him. In any event, it was all there. All twenty thousand\n" +
"dollars. Not bad for half an hour's work.\n" +
"Artemis turned back to the healer.\n" +
"'Now, madam, you have something that I want.'\n" +
"The healer's tongue caught a drop of alcohol at the corner of her mouth.\n" +
"'Yes, Irish. Sore head. Bad tooth. I heal.'\n" +
"Artemis replaced the night-vision goggles and squatted to her level.\n" +
"'I am perfectly healthy, madam, apart from a slight dust-mite allergy, and I don't think even\n" +
"you can do anything about that. No. What I want from you is your Book.'\n" +
"The hag froze. Bright eyes glinted from beneath the shawl.\n" +
"'Book?' she said cautiously. 'I don't know about no book. I am healer. You want book, go to\n" +
"library.'\n" +
"Artemis sighed with exaggerated patience. ' You are no healer. You are a sprite, p'shóg, fairy,\n" +
"ka-dalun. Whichever language you prefer to use. And I want your Book.'\n" +
"For a long moment the creature said nothing, then she threw back the shawl from her\n" +
"forehead. In the green glow of the night-vision goggles, her features leaped at Artemis like a\n" +
"Hallowe'en mask. The fairy's nose was long and hooked under two slitted golden eyes. Her\n" +
"ears were pointed, and the alcohol addiction had melted her skin like putty.\n" +
"'If you know about the Book, human,' she said slowly, fighting the numbing effects of the\n" +
"whiskey, 'then you know about the magic I have in my fist. I can kill you with a snap of my\n" +
"fingers!'\n" +
"Artemis shrugged. 'I think not. Look at you. You are near dead. The rice wine has dulled your\n" +
"senses. Reduced to healing warts. Pathetic. I am here to save you, in return for the Book.'\n" +
"'What could a human want with our Book?'\n" +
"'That is no concern of yours. All you need to know are your options.'\n" +
"The sprite's pointed ears quivered. Options?\n" +
"'One, you refuse to give us the Book and we go home, leaving you to rot in this sewer.'\n" +
"'Yes,' said the fairy. 'I choose this option.'\n" +
"'Ah no. Don't be so eager. If we leave without the Book, you will be dead in a day.'\n" +
"'A day! A day!'The healer laughed. 'I will outlive you by a century. Even fairies tethered to\n" +
"the human realm can survive the ages.'\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"12\n" +
"'Not with half a pint of holy water inside them,' said Artemis, tapping the now empty whiskey\n" +
"bottle.\n" +
"The fairy blanched, then screamed, a high keening horrible sound.\n" +
"'Holy water! You have murdered me, human.'\n" +
"'True,' admitted Artemis. 'It should start to burn any minute now.'\n" +
"The fairy poked her stomach tentatively. 'The second option?'\n" +
"'Listening now, are we? Very well then. Option two. You give me the Book for thirty minutes\n" +
"only. Then I return your magic to you.'\n" +
"The sprite's jaw dropped. 'Return my magic? Not possible.'\n" +
"'Oh but it is. I have in my possession two ampoules.\n" +
"One, a vial of spring water from the fairy well sixty metres below the ring of Tara - possibly\n" +
"the most magical place on earth. This will counteract the holy water.'\n" +
"'And the other?'\n" +
"'The other is a little shot of man-made magic. A virus that feeds on alcohol, mixed with a\n" +
"growth reagent. It will flush every drop of rice wine from your body, remove the dependence\n" +
"and even bolster your failing liver. It'll be messy, but after a day you'll be zipping around as\n" +
"though you were a thousand years old again.'\n" +
"The sprite licked her lips. To be able to rejoin the People? Tempting.\n" +
"'How do I know to trust you, human? You have tricked me once already.'\n" +
"'Good point. Here's the deal. I give you the water on faith. Then, after I've had a look at the\n" +
"Book, you get the booster. Take it or leave it.'\n" +
"The fairy considered. The pain was already curling around her abdomen. She thrust out her\n" +
"wrist.\n" +
"'I take it.'\n" +
"'I thought you might. Butler?'\n" +
"The giant manservant unwrapped a soft Velcroed case containing a syringe gun and two vials.\n" +
"He loaded the clear one, shooting it into the sprite's clammy arm. The fairy stiffened\n" +
"momentarily, and then relaxed.\n" +
"'Strong magic,' she breathed.\n" +
"'Yes. But not as strong as your own will be when I give you the second injection. Now, the\n" +
"Book.'\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"13\n" +
"The sprite reached into the folds of her filthy robe, rummaging for an age. Artemis held his\n" +
"breath. This was it. Soon the Fowls would be great again. A new empire would rise, with\n" +
"Artemis Fowl the Second at its head.\n" +
"The fairy woman withdrew a closed fist.\n" +
"'No use to you anyway. Written in the old tongue.'\n" +
"Artemis nodded, not trusting himself to speak.\n" +
"She opened her knobbly fingers. Lying in her palm was a tiny golden volume the size of a\n" +
"matchbox.\n" +
"'Here, human. Thirty of your minutes. No more.'\n" +
"Butler took the tiny tome reverentially. The bodyguard activated a compact digital camera and\n" +
"began photographing each wafer-thin page of the Book. The process took several minutes.\n" +
"When he was finished, the entire volume was stored on the camera's chip. Artemis preferred\n" +
"not to take chances with information. Airport security equipment had been known to wipe\n" +
"many a vital disk. So he instructed his aide to transfer the file to his portable phone and from\n" +
"there e-mail it to Fowl Manor in Dublin. Before the thirty minutes were up, the file containing\n" +
"every symbol in the Fairy Book was sitting safely in the Fowl server.\n" +
"Artemis returned the tiny volume to its owner.\n" +
"'Nice doing business with you.'\n" +
"The sprite lurched to her knees. 'The other potion, human?'\n" +
"Artemis smiled. 'Oh yes, the restoring booster. I suppose I did promise.'\n" +
"'Yes. Human promised.'\n" +
"'Very well. But before we administer it, I must warn you that purging is not pleasant. You're\n" +
"not going to enjoy this one bit.'\n" +
"The fairy gestured around her at the squalid filth. 'You think I enjoy this? I want to fly again.'\n" +
"Butler loaded the second vial, shooting this one straight into the carotid artery.\n" +
"The sprite immediately collapsed on the mat, her entire frame quivering violently.\n" +
"'Time to leave,' commented Artemis. 'A hundred years of alcohol leaving a body by any\n" +
"means possible is not a pretty sight.'\n" +
"The Butlers had been serving the Fowls for centuries. It had always been the way. Indeed\n" +
"there were several eminent linguists of the opinion that this was how the noun originated. The\n" +
"first record of this unusual arrangement was when Virgil Butler had been contracted as\n" +
"servant, bodyguard and cook to Lord Hugo de Pole for one of the first great Norman crusades.\n" +
"Artemis Fowl Chapter 1: The Book\n" +
"14\n" +
"At the age often, Butler children were sent to a private training centre in Israel, where they\n" +
"were taught the specialized skills necessary to guard the latest in the Fowl line. These skills\n" +
"included cordon bleu cooking, marksmanship, a customized blend of martial arts, emergency\n" +
"medicine and information technology. If, at the end of their training, there was not a Fowl to\n" +
"guard, then the Butlers were eagerly snapped up as bodyguards for various royal personages,\n" +
"generally in Monaco or Saudi Arabia.\n" +
"Once a Fowl and a Butler were put together, they were paired for life. It was a demanding job,\n" +
"and lonely, but the rewards were handsome if you survived to enjoy them. If not, then your\n" +
"family received a six-figure settlement plus a monthly pension.\n" +
"The current Butler had been guarding young Master Artemis for twelve years, since the\n" +
"moment of his birth. And, though they adhered to the age-old formalities, they were much\n" +
"more than master and servant. Artemis was the closest thing Butler had to a friend, and Butler\n" +
"was the closest Artemis had to a father, albeit one who obeyed orders.\n" +
"Butler held his tongue until they were aboard the Heathrow connection from Bangkok, then\n" +
"he had to ask.\n" +
"'Artemis?'\n" +
"Artemis looked up from the screen of his PowerBook. He was getting a head start on the\n" +
"translation.\n" +
"'Yes?'\n" +
"'The sprite. Why didn't we simply keep the Book and leave her to die?'\n" +
"'A corpse is evidence, Butler. My way, the People will have no reason to be suspicious.'\n" +
"'But the sprite?'\n" +
"'I hardly think she will confess to showing humans the Book. In any case, I mixed a slight\n" +
"amnesiac into her second injection. When she finally wakes up, the last week will be a blur.'\n" +
"Butler nodded appreciatively. Always two steps ahead, that was Master Artemis. People said\n" +
"he was a chip off the old block. They were wrong. Master Artemis was a brand-new block,\n" +
"the likes of which had never been seen before.\n" +
"Doubts assuaged, Butler returned to his copy of Guns and Ammo, leaving his employer to\n" +
"unravel the secrets of the universe.\n" +
"Artemis Fowl Chapter 2: Translation\n" +
"15\n" +
"CHAPTER 2: TRANSLATION\n" +
"BY now, you must have guessed just how far Artemis Fowl was prepared to go in order to\n" +
"achieve his goal. But what exactly was this goal? What outlandish scheme would involve the\n" +
"blackmailing of an alcohol-addicted sprite? The answer was gold.\n" +
"Artemis's search had begun two years previously when he first became interested in surfing\n" +
"the Internet. He quickly found the more arcane sites: alien abduction, UFO sightings and the\n" +
"supernatural. But most specifically the existence of the People.\n" +
"Trawling through gigabytes of data, he found hundreds of references to fairies from nearly\n" +
"every country in the world. Each civilization had its own term for the People, but they were\n" +
"undoubtedly members of the same hidden family. Several stories mentioned a Book carried\n" +
"by each fairy. It was their Bible, containing, as it allegedly did, the history of their race and\n" +
"the commandments that governed their extended lives. Of course, this Book was written in\n" +
"Gnommish, the fairy text, and would be of no use to any human.\n" +
"Artemis believed that with today's technology the Book could be translated. And with this\n" +
"translation you could begin to exploit a whole new group of creatures.\n" +
"Know thine enemy was Artemis's motto, so he immersed himself in the lore of the People\n" +
"until he had compiled a huge database on their characteristics. But it wasn't enough. So\n" +
"Artemis put out a call on the Web: Irish businessman will pay large amount of US dollars to\n" +
"meet a fairy, sprite, leprechaun, pixie. The responses had been mostly fraudulent, but Ho Chi\n" +
"Minh City had paid off.\n" +
"Artemis was perhaps the only person alive who could take full advantage of his recent\n" +
"acquisition. He still retained a childlike belief in magic, tempered by an adult determination to\n" +
"exploit it. If there was anybody capable of relieving the fairies of some of their magical gold,\n" +
"it was Artemis Fowl the Second.\n" +
"It was early morning before they reached Fowl Manor. Artemis was anxious to bring up the\n" +
"file on his computer, but first he decided to call in on Mother.\n" +
"Angeline Fowl was bedridden. She had been since her husband's disappearance. Nervous\n" +
"tension, the physicians said. Nothing for it but rest and sleeping pills. That was almost a year\n" +
"ago.\n" +
"Butler's little sister, Juliet, was sitting at the foot of the stairs. Her gaze was boring a hole in\n" +
"the wall. Even the glitter mascara couldn't soften her expression. Artemis had seen that look\n" +
"already, just before Juliet had suplexed a particularly cheeky pizza boy. The suplex, Artemis\n" +
"gathered, was a wrestling move. An unusual obsession for a teenage girl. But then again she\n" +
"was, after all, a Butler.\n" +
"'Problems, Juliet?'\n" +
"Juliet straightened hurriedly. 'My own fault, Artemis. Apparently I left a gap in the curtains.\n" +
"Mrs Fowl couldn't sleep.'\n" +
"'Hmm,' muttered Artemis, scaling the oak staircase slowly.\n" +
"Artemis Fowl Chapter 2: Translation\n" +
"16\n" +
"He worried about his mother's condition. She hadn't seen the light of day in a long time now.\n" +
"Then again, should she miraculously recover, emerging revitalized from her bedchamber, it\n" +
"would signal the end of Artemis's own extraordinary freedom. It would be back off to school,\n" +
"and no more spearheading criminal enterprises for you, my lad.\n" +
"He knocked gently on the arched double doors.\n" +
"'Mother? Are you awake?'\n" +
"Something smashed against the other side of the door. It sounded expensive.\n" +
"'Of course I'm awake! How can I sleep in this blinding glare?'\n" +
"Artemis ventured inside. An antique four-poster bed threw shadowy spires in the darkness,\n" +
"and a pale sliver of light poked through a gap in the velvet curtains. Angeline Fowl sat\n" +
"hunched on the bed, her pale limbs glowing white in the gloom.\n" +
"'Artemis, darling, where have you been?'\n" +
"Artemis sighed. She recognized him. That was a good sign.\n" +
"'School trip, Mother. Skiing in Austria.'\n" +
"'Ah, skiing,' crooned Angeline. 'How I miss it. Maybe when your father returns.'\n" +
"Artemis felt a lump in his throat. Most uncharacteristic.\n" +
"'Yes. Perhaps when Father returns.'\n" +
"'Darling, could you close those wretched curtains. The light is intolerable.'\n" +
"'Of course, Mother.'\n" +
"Artemis felt his way across the room, wary of the low-level clothes chests scattered about the\n" +
"floor. Finally his fingers curled around the velvet drapes. For a moment he was tempted to\n" +
"throw them wide open, then he sighed and closed the gap.\n" +
"'Thank you, darling. By the way, we really have to get rid of that maid. She is good for\n" +
"absolutely nothing.'\n" +
"Artemis held his tongue. Juliet had been a hardworking and loyal member of the Fowl\n" +
"household for the past three years. Time to use Mother's absent-mindedness to his advantage.\n" +
"'You're right of course, Mother. I've been meaning to do it for some time. Butler has a sister I\n" +
"believe would be perfect for the position. I think I've mentioned her. Juliet?'\n" +
"Angeline frowned. 'Juliet? Yes, the name does seem familiar. Well, anyone would be better\n" +
"than that silly girl we have now. When can she start?'\n" +
"'Straight away. I'll have Butler fetch her from the lodge.'\n" +
"Artemis Fowl Chapter 2: Translation\n" +
"17\n" +
"'You're a good boy, Artemis. Now give Mummy a hug.'\n" +
"Artemis stepped into the shadowy folds of his mother's robe. She smelled perfumed, like\n" +
"petals in water. But her arms were cold and weak.\n" +
"'Oh, darling,' she whispered, and the sound sent goosebumps popping down Artemis's neck. 'I\n" +
"hear things. At night. They crawl along the pillows and into my ears.'\n" +
"Artemis felt that lump in his throat again.\n" +
"'Perhaps we should open the curtains, Mother.'\n" +
"'No,' his mother sobbed, releasing him from her grasp. 'No. Because then I could see them\n" +
"too.'\n" +
"'Mother, please.'\n" +
"But it was no use. Angeline was her with gone. She crawled to the far corner of the bed, pulling the\n" +
"quilt under her chin.\n" +
"'Send the new girl.'\n" +
"'Yes, Mother.'\n" +
"'Send her with cucumber slices and water.'\n" +
"'Yes, Mother.'\n" +
"Angeline glared at him with crafty eyes. 'And stop calling me Mother. I don't know who you\n" +
"are, but you're certainly not my little Arty.'\n" +
"Artemis blinked back a few rebellious tears. 'Of course. Sorry, Moth - Sorry.'\n" +
"The End She crawled to She crawled to She crawled to ");
        Map<String, String> map = new HashMap();
        map.put(".", "");
        map.put("*", "");
        List<String> t;
        t = a.getTokens();
        t.stream().forEach((t1) -> {
            //System.out.println(t1);
        });
        NgramGraph bigram = new NgramGraph(2, t);
        System.out.println(bigram.getProb("She crawled with crafty eyes and the sound sent goosebumps?"));
        
        
        
        
        
        
        
        
        
        /*
        //String wnhome = System.getenv("C:\\Program Files (x86)\\WordNet\\2.1\\dict");
    String path = "C:\\Program Files (x86)\\WordNet\\2.1\\dict";
     URL url = null;
     try{ url = new URL("file", null, path); } 
     catch(MalformedURLException e){ e.printStackTrace(); }
     if(url == null) return;
    
    // construct the dictionary object and open it
    IDictionary dict = new Dictionary(url);
    dict.open();

    // look up first sense of the word "dog"
    IIndexWord idxWord = dict.getIndexWord("is", POS.VERB);
    IWordID wordID = idxWord.getWordIDs().get(0);
    IWord word = dict.getWord(wordID);
    System.out.println("Id = " + wordID);
    System.out.println("Lemma = " + word.getLemma());
    System.out.println("Gloss = " + word.getSynset().getGloss());
        */
        
        
        
        
    }
    
}
