# UI_UX_GUIDELINES.md — Diretrizes de Interface e Experiência do Usuário (UI/UX)
*Baseado no projeto NEXO, na identidade visual da coluna vertebral (Logo) e nos princípios da skill `frontend-design`.*

---

## 1. Identidade Visual e Conceito Base
A marca **NEXO** nasce da fusão entre anatomia estrutural (coluna vertebral / alinhamento) e tecnologia de ponta em quiropraxia. A identidade visual afasta-se de clichês de templates genéricos de saúde e adota uma estética **clínica, sofisticada, minimalista e de alta precisão**.

### Referência Visual Primária (Logo)
* **O Símbolo:** A coluna vertebral de alto contraste (tons monocromáticos, prata, branco puro e grafite profundo), transmitindo flexibilidade, suporte, eixo e movimento.
* **Sensação Passada:** Confiança absoluta, rigor anatômico, leveza no movimento e sofisticação tecnológica.

---

## 2. Sistema de Cores e Design Tokens
Evitando os padrões óbvios e genéricos de IA (como tons pastéis quentes ou acid greens), NEXO adota uma paleta inspirada em instrumentação clínica de precisão e escuros profundos do logotipo.

### Paleta Base (Dark Mode / Light Mode Adaptativos)
* **Primary (Deep Obsidian / Graphite):** `#090D16` (Fundo primário no Dark Mode / Elementos de alto contraste no Light Mode).
* **Secondary / Accent (Clinical Teal / Alinhamento):** `#0D9488` (Teal 600) e `#14B8A6` (Teal 500) — utilzados com parcimônia para CTAs e estados ativos, transmitindo saúde e precisão.
* **Surface / Cards:** 
  * *Light:* `#FFFFFF` com bordas sutis (`#E2E8F0`).
  * *Dark:* `#111827` (Gray 900) com bordas finas (`#1F2937`).
* **Text / Typography:**
  * *Light Main:* `#0F172A` (Slate 900).
  * *Dark Main:* `#F9FAFB` (Gray 50).
  * *Muted:* `#64748B` (Slate 500).

---

## 3. Tipografia e Escala
* **Família Tipográfica:** `Outfit` ou `Inter` (via Google Fonts) para um visual geométrico, limpo, moderno e altamente legível em exames e interfaces digitais.
* **Regras de Tipografia (Evitando Tells Genéricos):**
  * **Proibido:** Uso excessivo de ALL-CAPS em labels simples ou acentuação de uma única palavra isolada em cores chamativas em títulos.
  * **Hierarquia:** Títulos marcantes (Font-weight 600/700), subtítulos limpos e corpo com espaçamento de linha adequado (`line-height: 1.6`, com largura máxima de linha controlada para leitura fluida).

---

## 4. Princípios de Layout e Restrição Visual
* **O Hero Section:** Em vez do padrão genérico de SaaS (título + subtítulo + badge + gradiente lavado), a Home abrirá com a proposta central de movimento e alinhamento corporal, integrando a estética visual da coluna vertebral com tipografia imponente e CTAs diretos ("Agende sua consulta").
* **Estrutura de Cards:** Evitar o "SaaS-card kit" repetitivo. Cada seção (Sobre a Clínica, Sobre o Profissional, Serviços) terá tratamento visual próprio e espaçamentos generosos, sem sombras pesadas ou bordas excessivamente arredondadas em blocos idênticos.
* **Movimento e Microinterações:** Animações apenas quando justificadas e funcionais (ex: feedback de agendamento confirmado, abertura de modais ou transição de temas claro/escuro). Sem fade-in exagerado em cada card de rolagem.

---

## 5. Diretrizes para Thymeleaf, CSS e JavaScript
* **Framework CSS:** Tailwind CSS via CDN para prototipagem ágil e manutenção de tokens consistentes.
* **Tema Claro / Escuro (Light & Dark Mode):** Implementação nativa via classes no elemento raiz (`class="dark"` ou toggle via JavaScript salvando preferência no `localStorage`).
* **Copywriting:** Linguagem direta, ativa e voltada ao paciente ("Escolha seu horário", "Confirmar agendamento"), sem jargões corporativos vazios.
