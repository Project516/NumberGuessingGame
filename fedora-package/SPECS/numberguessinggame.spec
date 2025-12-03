# SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
#
# SPDX-License-Identifier: GPL-3.0-or-later

Name:           numberguessinggame
Version:        1.0.0
Release:        1%{?dist}
Summary:        A simple number guessing game

License:        GPL-3.0-or-later
URL:            https://github.com/Project516/NumberGuessingGame
Source0:        game.jar

BuildArch:      noarch
Requires:       java-1.8.0-openjdk-headless

%description
A simple number guessing game where you try to guess a randomly
generated number. The game features both a user-friendly graphical
user interface (GUI) and a classic console mode. High scores are
tracked and stored persistently.

%prep
# No prep needed for prebuilt JAR

%build
# No build needed for prebuilt JAR

%install
rm -rf %{buildroot}

# Create directories
mkdir -p %{buildroot}%{_datadir}/games/%{name}
mkdir -p %{buildroot}%{_bindir}

# Install JAR file
install -m 644 %{SOURCE0} %{buildroot}%{_datadir}/games/%{name}/game.jar

# Create wrapper script
cat > %{buildroot}%{_bindir}/%{name} <<'EOF'
#!/bin/sh
# Wrapper script to launch Number Guessing Game
java -jar %{_datadir}/games/%{name}/game.jar "$@"
EOF

chmod 755 %{buildroot}%{_bindir}/%{name}

%files
%{_bindir}/%{name}
%{_datadir}/games/%{name}/game.jar

%changelog
* Tue Dec 03 2024 Project516 <138796702+Project516@users.noreply.github.com> - 1.0.0-1
- Initial Fedora package release
